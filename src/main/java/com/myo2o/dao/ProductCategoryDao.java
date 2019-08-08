package com.myo2o.dao;

import com.myo2o.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryDao {
    /**
     * 通过店铺shopid查询店铺商品类别
     * @param shopId
     * @return
     */
    List<ProductCategory> queryProductCategoryList(long shopId);
}
