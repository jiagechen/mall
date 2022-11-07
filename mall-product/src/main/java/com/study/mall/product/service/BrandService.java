package com.study.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.mall.mallcommons.utils.PageUtils;
import com.study.mall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author jgc
 * @email 1594873251@qq.com
 * @date 2022-11-04 15:23:56
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

