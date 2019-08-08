package test.com.myo2o.service;

import static org.junit.Assert.assertEquals;

import test.com.myo2o.BaseTest;

import java.util.List;

import com.myo2o.service.AreaService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.myo2o.entity.Area;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AreaServiceTest extends BaseTest {
	@Autowired
	private AreaService areaService;
	@Test
	public void testGetAreaList() {
		List<Area>areaList=areaService.getAreaList();
		assertEquals("东苑", areaList.get(0).getAreaDesc());
	}
}
