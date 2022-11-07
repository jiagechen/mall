package com.study.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.mall.coupon.entity.SmsSkuFullReductionEntity;
import com.study.mall.mallcommons.utils.PageUtils;

import java.util.Map;

/**
 * 商品满减信息
 *
 * @author jgc
 * @email 1594873251@qq.com
 * @date 2022-11-04 16:42:56
 */
public interface SmsSkuFullReductionService extends IService<SmsSkuFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
