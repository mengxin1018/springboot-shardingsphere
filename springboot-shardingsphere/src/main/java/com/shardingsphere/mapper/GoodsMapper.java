package com.shardingsphere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shardingsphere.domin.Goods;

public interface GoodsMapper {

	/**
	 * 新增商品
	 * @param user
	 */
	public void addGoods(Goods user);
	
	/**
	 * 更新商品
	 * @param user
	 */
	public void updateGoods(Goods user);
	
	/**
	 * 删除商品
	 * @param id
	 */
	public void delete(String id);
	
	/**
	 * 查询商品
	 * @param ids
	 * @return
	 */
	public List<Goods> selectGoodsList(@Param(value = "ids") List<String> ids);
}
