package com.myo2o.service;

import java.io.InputStream;

import com.myo2o.dto.ShopExecution;
import com.myo2o.entity.Shop;
import com.myo2o.exceptions.ShopOperationException;

public interface ShopService {
	// 插入店铺首先需要将Shop对象插入到数据库中，然后返回店铺id，通过id去创建存储图片的文件夹
	/**
	 * 注册店铺，包括图片处理
	 */
	ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName)throws ShopOperationException;

	/**
	 * 通过店铺id获取店铺信息
	 */
	Shop getByShopId(long shopId);
	/**
	 * 更新店铺信息，包括对图片的处理
	 */
	ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName)throws ShopOperationException;
	/**
	 * 根据shopCondition分页返回相应的店铺列表数据
	 * @param shopCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);
}
