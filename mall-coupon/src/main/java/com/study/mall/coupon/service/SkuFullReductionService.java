package com.study.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.mall.coupon.entity.SkuFullReductionEntity;
import com.study.mall.mallcommons.utils.PageUtils;

import java.util.Map;

/**
 * 商品满减信息
 *
 * @author jgc
 * @email 1594873251@qq.com
 * @date 2022-11-07 22:26:36
 */
public interface SkuFullReductionService extends IService<SkuFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

