package com.myo2o.service.impl;

import com.myo2o.dao.ProductCategoryDao;
import com.myo2o.entity.ProductCategory;
import com.myo2o.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;
    @Override
    public List<ProductCategory> getProductCategoryList(long shopId) {
        return productCategoryDao.queryProductCategoryList(shopId);
    }
}
