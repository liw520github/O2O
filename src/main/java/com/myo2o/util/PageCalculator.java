package com.myo2o.util;

//因为前端只认页数，后端只认行数，所以这个工具类是实现把页数转换成行数
public class PageCalculator {
	public static int calculateRownIndex(int pageIndex, int pageSize) {
		//
		return (pageIndex > 0) ? (pageIndex - 1) * pageSize : 0;
	}
}
