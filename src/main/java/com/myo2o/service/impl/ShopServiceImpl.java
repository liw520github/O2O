package com.myo2o.service.impl;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myo2o.dao.ShopDao;
import com.myo2o.dto.ShopExecution;
import com.myo2o.entity.Shop;
import com.myo2o.enums.ShopStateEnum;
import com.myo2o.exceptions.ShopOperationException;
import com.myo2o.service.ShopService;
import com.myo2o.util.FileUtil;
import com.myo2o.util.ImageUtil;
import com.myo2o.util.PageCalculator;

@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopDao shopDao;

	@Override
	@Transactional
	public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) {
		/*
		 * 1、空值判断 2、给店铺信息赋初始值 3、添加店铺信息
		 */
		if (shop == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}
		try {
			shop.setEnableStatus(0);// 表示为上架
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			int effectedNum = shopDao.insertShop(shop);
			if (effectedNum <= 0) {
				throw new ShopOperationException("店铺创建失败");
			} else {
				if (shopImgInputStream != null) {
					// 存储图片
					try {
						addShopImg(shop, shopImgInputStream, fileName);

					} catch (Exception e) {
						throw new ShopOperationException("addShopImg erro:" + e.getMessage());
					}
					// 更新店铺的图片地址
					effectedNum = shopDao.updateShop(shop);
					if (effectedNum <= 0) {
						throw new ShopOperationException("更新图片地址失败");
					}
				}
			}
		} catch (Exception e) {
			throw new ShopOperationException("addShop error:" + e.getMessage());
		}
		return new ShopExecution(ShopStateEnum.CHECK);
	}

	private void addShopImg(Shop shop, InputStream shopImgInputStream, String fileName) {

		// 获取shop图片目录的相对路径
		String deString = FileUtil.getShopImagePath(shop.getShopId());
		String shopImgAddrString = ImageUtil.generateThumbnail(shopImgInputStream, fileName, deString);
		shop.setShopImg(shopImgAddrString);
	}

//根据店铺id获取店铺信息
	@Override
	public Shop getByShopId(long shopId) {

		return shopDao.queryByShopId(shopId);
	}

	@Override
	public ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName)
			throws ShopOperationException {
		if (shop == null || shop.getShopId() == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		} else {
			try {
				// 1、判断是否需要处理图片
				if (shopImgInputStream != null && fileName != null && !fileName.equals("")) {
					Shop tempShop = shopDao.queryByShopId(shop.getShopId());
					if (tempShop.getShopImg() != null) {
						ImageUtil.deleteFileOrPath(tempShop.getShopImg());
					}
					// 这里为什么是传shop，因为addShopImg会重新给shop赋予一个新的图片地址
					addShopImg(shop, shopImgInputStream, fileName);
				}
				// 2.更新店铺信息
				shop.setLastEditTime(new Date());
				int effectedNum = shopDao.updateShop(shop);
				if (effectedNum <= 0) {
					return new ShopExecution(ShopStateEnum.INNER_ERROR);
				} else {
					shop = shopDao.queryByShopId(shop.getShopId());
					return new ShopExecution(ShopStateEnum.SUCCESS, shop);
				}
			} catch (Exception e) {
				throw new ShopOperationException("modifyShop error:" + e.getMessage());
			}

		}

	}

//通过条件获取店铺信息
	@Override
	public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) {
		int rowIndex = PageCalculator.calculateRownIndex(pageIndex, pageSize);
		List<Shop> shopList = shopDao.queryShopList(shopCondition, rowIndex, pageSize);
		int count = shopDao.queryShopCount(shopCondition);
		ShopExecution se = new ShopExecution();
		if (shopList != null) {
			se.setShopList(shopList);
			se.setCount(count);
		} else {
			se.setState(ShopStateEnum.INNER_ERROR.getState());
		}
		return se;
	}
}
