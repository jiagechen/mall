package com.study.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.mall.coupon.entity.MemberPriceEntity;
import com.study.mall.mallcommons.utils.PageUtils;

import java.util.Map;

/**
 * 商品会员价格
 *
 * @author jgc
 * @email 1594873251@qq.com
 * @date 2022-11-07 22:26:36
 */
public interface MemberPriceService extends IService<MemberPriceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

