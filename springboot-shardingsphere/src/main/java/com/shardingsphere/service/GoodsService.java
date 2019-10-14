package com.shardingsphere.service;

import java.util.List;
import java.util.Map;

import com.shardingsphere.domin.Goods;


public interface GoodsService {

	public void addGoods(Map<String,Object> param);
	
	public void deleteGoods(Map<String,Object> param);
	
	public void updateGoods(Map<String,Object> param);
	
	public List<Goods> selectGoods(Map<String,Object> param);
}
