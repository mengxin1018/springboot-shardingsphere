package com.shardingsphere.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.shardingsphere.base.BaseUnitTest;
import com.shardingsphere.domin.Goods;
import com.shardingsphere.service.GoodsService;

public class GoodsServiceImplTest extends BaseUnitTest {

	@Autowired
	private GoodsService goodsService;

	@Test
	public void addUserTest() {
		try {
			for (int i = 0; i < 50; i++) {
				Map<String, Object> goodsMap = new HashMap<>();
				goodsMap.put("name", "商品1");
				goodsMap.put("type", 1);
				goodsMap.put("status", Math.random()*10+1);
				goodsMap.put("price", "10");
				goodsService.addGoods(goodsMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void selectGoodsTest() {
		try {
			List<Long> ids = new ArrayList<>();
			ids.add(Long.valueOf("390543109961830400"));
			ids.add(Long.valueOf("390543110075076608"));
			Map<String,Object> param = new HashMap<>();
			param.put("ids",ids );
			List<Goods> goodsList = goodsService.selectGoods(param);
			System.out.println(goodsList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteUserTest() {
		Map<String,Object> param = new HashMap<>();
		param.put("id","390462534055907329" );
		goodsService.deleteGoods(param);
	}
	
	@Test
	public void updateGoodsTest() {
		Map<String, Object> goodsMap = new HashMap<>();
		goodsMap.put("goods_id", "390462534517280769");
		goodsMap.put("price", "100");
		goodsService.updateGoods(goodsMap);
	}
}
