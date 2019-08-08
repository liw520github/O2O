package com.myo2o.web.superadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "shopadmin", method = { RequestMethod.GET })
public class ShopAdminController {
	@RequestMapping(value = "/shopoperation")
	public String shopOperation() {
		return "shop/shopoperation";//这里只需要这样写，因为在spring-web中已经配置了文件的根布局和后缀名
	}
	@RequestMapping(value = "/shoplist")
	public String shopList() {
		return "shop/shoplist";//这里只需要这样写，因为在spring-web中已经配置了文件的根布局和后缀名
	}
	@RequestMapping(value = "/shopmanagement")
	public String shopManagement() {
		return "shop/shopmanagement";//这里只需要这样写，因为在spring-web中已经配置了文件的根布局和后缀名
	}

}
