package com.myo2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myo2o.entity.Shop;

public interface ShopDao {
	/**
	 * 分页查询店铺，可输入的条件有：店铺名(模糊)，店铺状态，店铺类型，区域id，owner
	 * @param shopCondition 查询的条件
	 * @param rowIndex 从第几行开始取数据
	 * @param pageSize 返回的条数
	 * @return
	 */
	List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition,
                             @Param("rowIndex") int rowIndex,
                             @Param("pageSize") int pageSize);
	/**
	 * 返回queryShopList总数
	 * @param shopCondition
	 * @return
	 */
  int queryShopCount(@Param("shopCondition") Shop shopCondition);
	/**
	 * 通过shop id 查询店铺
	 * 
	 */
	Shop queryByShopId(long shopId);

	/**
	 * 新增店铺
	 * 
	 * @param shop
	 * @return 1插入成功
	 */
	int insertShop(Shop shop);

	/**
	 * 更新店铺
	 * 
	 * @param shop
	 * @return
	 */
	int updateShop(Shop shop);
}
