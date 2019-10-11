package com.shardingsphere.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.shardingsphere.domin.Goods;


public interface GoodsService {

	public void addUser(Map<String,Object> param);
	
	public void deleteUser(Map<String,Object> param);
	
	public void updateUser(Map<String,Object> param);
	
	public List<Goods> selectUsers(Map<String,Object> param);
}
