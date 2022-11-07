package com.study.mall.order.dao;

import com.study.mall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author jgc
 * @email 1594873251@qq.com
 * @date 2022-11-07 22:10:51
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
