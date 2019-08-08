package test.com.myo2o.dao;


import com.myo2o.dao.ProductCategoryDao;
import com.myo2o.entity.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import test.com.myo2o.BaseTest;
import java.util.List;

public class ProductCategoryDaoTest extends BaseTest {
   @Autowired
   private ProductCategoryDao shopCategoryDao;
    @Test
    public void queryProductCategoryList() {
        long shopId=15L;
        List<ProductCategory> shopCategoryList =shopCategoryDao.queryProductCategoryList(shopId);

        for (int i = 0; i <shopCategoryList.size() ; i++) {
            System.out.println(shopCategoryList.get(i).getProductCategoryName());
        }
    }
}
