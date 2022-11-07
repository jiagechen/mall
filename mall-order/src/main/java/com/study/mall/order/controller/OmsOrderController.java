package com.study.mall.order.controller;

import java.util.Arrays;
import java.util.Map;

import com.study.mall.mallcommons.utils.PageUtils;
import com.study.mall.mallcommons.utils.R;
import com.study.mall.order.fegin.ProductService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import com.study.mall.order.entity.OmsOrderEntity;
import com.study.mall.order.service.OmsOrderService;




/**
 * 订单
 *
 * @author jgc
 * @email 1594873251@qq.com
 * @date 2022-11-04 16:32:49
 */
//通过RefreshScope来动态刷新配置数据 - application.yml中的内容
@RefreshScope
@RestController
@RequestMapping("order/omsorder")
public class OmsOrderController {
    @Autowired
    private OmsOrderService omsOrderService;
    @Autowired
    private ProductService productService;

    @Value("${user.userName}")
    private String userName;

    @Value("${user.age}")
    private Integer age;

    @GetMapping("/users")
    public R queryUser(){
        return R.ok().put("userName" , userName).put("age" , age);
    }

    @GetMapping("/products")
    public R queryProduct(){
        //OpenFegin 远程调用服务
        return R.ok().put("products",productService.queryAllBrand());
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("order:omsorder:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = omsOrderService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("order:omsorder:info")
    public R info(@PathVariable("id") Long id){
		OmsOrderEntity omsOrder = omsOrderService.getById(id);

        return R.ok().put("omsOrder", omsOrder);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("order:omsorder:save")
    public R save(@RequestBody OmsOrderEntity omsOrder){
		omsOrderService.save(omsOrder);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("order:omsorder:update")
    public R update(@RequestBody OmsOrderEntity omsOrder){
		omsOrderService.updateById(omsOrder);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("order:omsorder:delete")
    public R delete(@RequestBody Long[] ids){
		omsOrderService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
