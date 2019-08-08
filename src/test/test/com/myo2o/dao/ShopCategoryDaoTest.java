package test.com.myo2o.dao;

import static org.junit.Assert.assertEquals;

import test.com.myo2o.BaseTest;
import java.util.List;

import com.myo2o.dao.ShopCategoryDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.myo2o.entity.ShopCategory;

public class ShopCategoryDaoTest extends BaseTest {
	@Autowired
	private ShopCategoryDao shopCategoryDao;

	@Test
	public void testQueryShopCategory() throws Exception {
		List<ShopCategory> shopCategories = shopCategoryDao.queryShopCategory(new ShopCategory());
//		assertEquals(19, shopCategories.size());
		ShopCategory shopCategory =new ShopCategory();
		shopCategory.setParentId(10L);
		shopCategories =shopCategoryDao.queryShopCategory(shopCategory);
		assertEquals(2, shopCategories.size());
		System.out.println(shopCategories.get(0).getShopCategoryName());
	}
}
