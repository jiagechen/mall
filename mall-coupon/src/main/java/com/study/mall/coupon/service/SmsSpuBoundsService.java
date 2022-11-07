package com.study.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.mall.coupon.entity.SmsSpuBoundsEntity;
import com.study.mall.mallcommons.utils.PageUtils;

import java.util.Map;

/**
 * 商品spu积分设置
 *
 * @author jgc
 * @email 1594873251@qq.com
 * @date 2022-11-04 16:42:56
 */
public interface SmsSpuBoundsService extends IService<SmsSpuBoundsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

