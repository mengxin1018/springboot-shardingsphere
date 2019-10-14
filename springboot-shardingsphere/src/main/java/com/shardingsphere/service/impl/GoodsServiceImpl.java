package com.shardingsphere.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shardingsphere.domin.Goods;
import com.shardingsphere.mapper.GoodsMapper;
import com.shardingsphere.service.GoodsService;
import com.shardingsphere.utils.InputMapValidateUtil;
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
	
	@Override
	public void addGoods(Map<String, Object> param) {
		String name = InputMapValidateUtil.getString(param, "name");
		String price = InputMapValidateUtil.getString(param, "price");
		Integer status = InputMapValidateUtil.getIntValue(param, "status", 0);
		Integer Type = InputMapValidateUtil.getIntValue(param, "type", 0);
		
		Goods goods = new Goods();
		goods.setEditTime(new Date());
		goods.setGoodsName(name);
		goods.setGoodsType(Type);
		goods.setPrice(price);
		goods.setStatus(status);
		
		goodsMapper.addGoods(goods);
	}

	@Override
	public void deleteGoods(Map<String, Object> param) {

		Long id = InputMapValidateUtil.getLongValue(param, "id", 1);
		
		goodsMapper.delete(id);
	}

	@Override
	public void updateGoods(Map<String, Object> param) {
		JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(param));
		
		Goods goods = jsonObject.toJavaObject(Goods.class);
		
		goodsMapper.updateGoods(goods);
	}

	@Override
	public List<Goods> selectGoods(Map<String, Object> param) {
		
		List<Long> ids = (List<Long>) param.get("ids");
		List<Goods> goodsList = goodsMapper.selectGoodsList(ids);
		return goodsList;
	}

}
