package com.myo2o.service;

import java.util.List;

import com.myo2o.entity.ShopCategory;

public interface ShopCategoryService {
  List<ShopCategory>getShopCategoryList(ShopCategory shopCategoryCondition);
}
