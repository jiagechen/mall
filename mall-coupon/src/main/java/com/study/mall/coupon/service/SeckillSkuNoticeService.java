package com.study.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.mall.coupon.entity.SeckillSkuNoticeEntity;
import com.study.mall.mallcommons.utils.PageUtils;

import java.util.Map;

/**
 * 秒杀商品通知订阅
 *
 * @author jgc
 * @email 1594873251@qq.com
 * @date 2022-11-07 22:26:36
 */
public interface SeckillSkuNoticeService extends IService<SeckillSkuNoticeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

