package com.study.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.mall.coupon.entity.SeckillPromotionEntity;
import com.study.mall.mallcommons.utils.PageUtils;

import java.util.Map;

/**
 * 秒杀活动
 *
 * @author jgc
 * @email 1594873251@qq.com
 * @date 2022-11-07 22:26:36
 */
public interface SeckillPromotionService extends IService<SeckillPromotionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

