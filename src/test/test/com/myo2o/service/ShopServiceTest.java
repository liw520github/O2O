package test.com.myo2o.service;

import static org.junit.Assert.assertEquals;

import test.com.myo2o.BaseTest;

import com.myo2o.service.ShopService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myo2o.dto.ShopExecution;
import com.myo2o.entity.Shop;
import com.myo2o.entity.ShopCategory;

public class ShopServiceTest extends BaseTest {
	// 这个注解是将ShopService的实现类动态注入到这个接口里面
	@Autowired
	private ShopService shopService;

	@Test
	public void testGetShopListAndCount() {
		Shop shopCondition=new Shop();
		ShopCategory shopCategory =new ShopCategory();
		shopCategory.setShopCategoryId(10L);
		shopCondition.setShopCategory(shopCategory);
		ShopExecution se=shopService.getShopList(shopCondition, 4, 2);
		System.out.println("店铺列表数为："+se.getShopList().size());
		System.out.println("店铺总数为："+se.getCount());
	}
//	@Test
//	@Ignore
//	public void testModifyShop() throws ShopOperationException, FileNotFoundException {
//		Shop shop = new Shop();
//		shop.setShopId(59L);
//		shop.setShopName("修改后的店铺名称");
//
//		File shopImg = new File("D:\\projectdev\\image\\upload\\images\\item\\shop\\59\\4f7cfcb9a533b124.jpg");
//		InputStream inputStream = new FileInputStream(shopImg);
//		ShopExecution shopExecution =shopService.modifyShop(shop, inputStream, "4f7cfcb9a533b124.jpg");
//	System.out.println("新的图片地址"+shopExecution.getShop().getShopImg());
//	}
//
//	@Test
//	@Ignore
//	public void testAddShop() throws FileNotFoundException {
//		Shop shop = new Shop();
//		PersonInfo owner = new PersonInfo();
////    	setUserId, 外键对应的表里面也要有个这个相同的键值
//		owner.setUserId(1L);
//		Area area = new Area();
//		area.setAreaId(1L);
//		ShopCategory sc = new ShopCategory();
//		sc.setShopCategoryId(1L);
//		shop.setOwner(owner);
//		shop.setArea(area);
//		shop.setShopCategory(sc);
//		shop.setShopName("测试店铺5");
//		shop.setShopDesc("666");
//		shop.setShopAddr("666");
//		shop.setPhone("13810524564");
//		shop.setCreateTime(new Date());
//		shop.setLastEditTime(new Date());
//		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
//		shop.setAdvice("审核中");
//
//		File shopImg = new File("F:\\testphoto\\photo.jpeg");
//		InputStream inputStream = new FileInputStream(shopImg);
//		ShopExecution sExecution = shopService.addShop(shop, inputStream, shopImg.getName());
//		assertEquals(ShopStateEnum.CHECK.getState(), sExecution.getState());
//	}

}
