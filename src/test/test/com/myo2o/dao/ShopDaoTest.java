package test.com.myo2o.dao;

import static org.junit.Assert.assertEquals;

import test.com.myo2o.BaseTest;

import java.util.List;

import com.myo2o.dao.ShopDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.myo2o.entity.PersonInfo;
import com.myo2o.entity.Shop;

public class ShopDaoTest extends BaseTest {
	@Autowired
	private ShopDao shopDao;

	@Test
	public void testQueryShopListAndCount() {
		Shop shopConditionShop =new Shop();
		PersonInfo ownerInfo =new PersonInfo();
		ownerInfo.setUserId(1L);
		shopConditionShop.setOwner(ownerInfo);
		List<Shop>shopList=shopDao.queryShopList(shopConditionShop, 0, 5);
		System.out.println("店铺列表的大小："+shopList.size());
  	    int count =shopDao.queryShopCount(shopConditionShop);
  	    System.out.println("店铺总数量："+count);
	}
//	@Test
//	@Ignore
//	public void testQueryByShopId() {
//		long shopId = 15;
//		Shop shop = shopDao.queryByShopId(shopId);
//		System.out.println("areaId:" + shop.getArea().getAreaId());
//		System.out.println("areaName:" + shop.getArea().getAreaName());
//		System.out.println(shop);
//
//	}
	// @Ignore标签表示不走这方法
//	@Test
//	@Ignore
//	public void testInsertShop() throws Exception {
//		Shop shop = new Shop();
//		PersonInfo owner = new PersonInfo();
////    	setUserId, 外键对应的表里面也要有个这个相同的键值
//		owner.setUserId(1L);
//		Area area = new Area();
//		area.setAreaId(1L);
//		ShopCategory sc = new ShopCategory();
//		sc.setShopCategoryId(1L);
//		shop.setOwner(owner);
//		// shop.setOwnerId(owner.getUserId());
//		shop.setArea(area);
//		shop.setShopCategory(sc);
//		shop.setShopName("mytest1");
//		shop.setShopDesc("mytest1");
//		shop.setShopAddr("testaddr1");
//		shop.setPhone("13810524526");
//		shop.setShopImg("test1");
//		shop.setCreateTime(new Date());
//		shop.setLastEditTime(new Date());
//		shop.setEnableStatus(1);
//		shop.setAdvice("审核中");
//
//		int effectedNum = shopDao.insertShop(shop);
//		assertEquals(1, effectedNum);
//	}
//
//	@Test
//	@Ignore
//	public void testUpdateShop() throws Exception {
//		Shop shop = new Shop();
//		shop.setShopId(54L);
//		shop.setShopDesc("测试更新描述");
//		shop.setShopAddr("测试更新地址");
//		shop.setLastEditTime(new Date());
//		int effectedNum = shopDao.updateShop(shop);
//		assertEquals(1, effectedNum);
//	}

}
