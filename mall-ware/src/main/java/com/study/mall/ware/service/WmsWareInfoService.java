package com.study.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.mall.mallcommons.utils.PageUtils;
import com.study.mall.ware.entity.WmsWareInfoEntity;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author jgc
 * @email 1594873251@qq.com
 * @date 2022-11-04 16:47:30
 */
public interface WmsWareInfoService extends IService<WmsWareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

