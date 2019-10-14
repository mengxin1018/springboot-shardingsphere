package com.shardingsphere.domin;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Goods {

	private Long goodsId;
	
	private Integer goodsType;
	
	private String goodsName;
	
	private Integer status;
	
	private String price;
	
	private Date editTime;
}
