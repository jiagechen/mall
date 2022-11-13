package com.study.mall.product.service.impl;

import com.study.mall.mallcommons.utils.PageUtils;
import com.study.mall.mallcommons.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.study.mall.product.dao.CategoryDao;
import com.study.mall.product.entity.CategoryEntity;
import com.study.mall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 查询所有的类别数据，然后将数据封装为树形结构，便于前端使用
     * @param params
     * @return
     */
    @Override
    public List<CategoryEntity> queryPageWithTree(Map<String, Object> params) {
        /**
         * 非注入，just Class<CategoryServiceImpl> 继承 Class<ServiceImpl>， Class<ServiceImpl> 含有成员变量 baseMapper，之后调用 baseMapper 内的方法
         */
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);
        List<CategoryEntity> list = categoryEntities.stream().filter(entity ->
                entity.getParentCid() == 0).map(entity -> {
                    entity.setChildrens(getCategoryChildren(entity,categoryEntities));
                    return entity;
        }).sorted((entity1 , entity2) -> {
            return (entity1.getSort() == null ? 0 : entity1.getSort()) - (entity2.getSort() == null ? 0 : entity2.getSort());
        }).collect(Collectors.toList());
        return list;
    }
    private List<CategoryEntity> getCategoryChildren(CategoryEntity categoryEntity ,
                                                     List<CategoryEntity> categoryEntities){
        List<CategoryEntity> collection = categoryEntities.stream().filter(entity -> {
            return entity.getParentCid().equals(categoryEntity.getCatId());//entity.getParentCid() == categoryEntity.getCatId();
        }).map(entity -> {
            entity.setChildrens(getCategoryChildren(entity , categoryEntities));
            return entity;
        }).sorted((entity1 , entity2) -> {
            return (entity1.getSort() == null ? 0 : entity1.getSort()) - (entity2.getSort() == null ? 0 : entity2.getSort());
        }).collect(Collectors.toList());
        return collection;
    }

    /**
     * 逻辑批量删除操作
     * @param ids
     */
    @Override
    public void removeCategoryByIds(List<Long> ids) {
        // TODO  1.检查类别数据是否在其他业务中使用

        // 2.批量逻辑删除操作
        baseMapper.deleteBatchIds(ids);

    }
}