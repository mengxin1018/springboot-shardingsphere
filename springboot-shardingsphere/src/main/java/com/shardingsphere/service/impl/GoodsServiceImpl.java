package com.shardingsphere.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shardingsphere.domin.Goods;
import com.shardingsphere.mapper.GoodsMapper;
import com.shardingsphere.service.GoodsService;
import com.shardingsphere.utils.InputMapValidateUtil;
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
	
	@Override
	public void addUser(Map<String, Object> param) {
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
	public void deleteUser(Map<String, Object> param) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(Map<String, Object> param) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Goods> selectUsers(Map<String, Object> param) {
		
		List<String> ids = (List<String>) param.get("ids");
		List<Goods> goodsList = goodsMapper.selectGoodsList(ids);
		return goodsList;
	}

}
