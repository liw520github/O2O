package com.myo2o.web.superadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myo2o.entity.Area;
import com.myo2o.service.AreaService;
import ch.qos.logback.core.db.dialect.H2Dialect;
import sun.util.logging.resources.logging;

@Controller
@RequestMapping("/superadmin")
public class AreaController {
	Logger logger=LoggerFactory.getLogger(AreaController.class);
	// autowired,在程序需要用到service时将areaservice实现类给注入进来，
	// 进而可以使用实现类里面的方法
	@Autowired
	private AreaService areaService;

	// 前端访问我后端的这个方法为/listarea
	@RequestMapping(value = "/listarea", method = RequestMethod.GET)
	// 下面这个注解是将我们的model对象转换成json传给前端
	@ResponseBody
	private Map<String, Object> listArea() {
		logger.info("---start---");
	    long startTime =System.currentTimeMillis();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Area> list = new ArrayList<Area>();
		try {
			list = areaService.getAreaList();
			modelMap.put("rows", list);
			modelMap.put("total", list.size());
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}
		logger.error("test error!");
		long endTime =System.currentTimeMillis();
		logger.debug("costTime:[{}ms]",endTime-startTime);
		logger.info("---end---");
		return modelMap;
	}

}
