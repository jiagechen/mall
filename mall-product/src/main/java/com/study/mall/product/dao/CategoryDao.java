package com.study.mall.product.dao;

import com.study.mall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author jgc
 * @email 1594873251@qq.com
 * @date 2022-11-04 15:23:56
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
