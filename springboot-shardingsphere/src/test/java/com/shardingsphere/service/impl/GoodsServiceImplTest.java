package com.shardingsphere.service.impl;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.shardingsphere.base.BaseUnitTest;
import com.shardingsphere.domin.Goods;
import com.shardingsphere.service.GoodsService;

public class GoodsServiceImplTest extends BaseUnitTest {

	@Autowired
	private GoodsService goodsService;

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void addUserTest() {
		try {
			for (int i = 0; i < 50; i++) {

				Map<String, Object> goodsMap = new HashMap<>();
				goodsMap.put("name", "商品1");
				goodsMap.put("type", 1);
				
				goodsMap.put("status", i);
				goodsMap.put("price", "10");

				goodsService.addUser(goodsMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@Test
	public void selectGoodsTest() {
		try {
			List<String> ids = new ArrayList<>();
			ids.add("389437697631977472");
			ids.add("389437697615200257");
			Map<String,Object> param = new HashMap<>();
			param.put("ids", ids);
			List<Goods> goodsList = goodsService.selectUsers(param);
			System.out.println(goodsList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
