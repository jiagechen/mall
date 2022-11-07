package com.study.mall.member.dao;

import com.study.mall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author jgc
 * @email 1594873251@qq.com
 * @date 2022-11-07 22:44:19
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
