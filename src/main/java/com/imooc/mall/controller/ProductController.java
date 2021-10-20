package com.imooc.mall.controller;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.common.ApiRestResponse;
import com.imooc.mall.model.pojo.Product;
import com.imooc.mall.model.request.ProductListReq;
import com.imooc.mall.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author honggw
 * @create 2021-10-12 9:33
 */
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @ApiOperation("商品详情")
    @PostMapping("product/detail")
    public ApiRestResponse detail(@RequestParam Integer id){
        Product product = productService.detail(id);
        return ApiRestResponse.success(product);
    }

    @ApiOperation("前台列表")
    @PostMapping("product/list")
    public ApiRestResponse list(ProductListReq productListReq){
        System.out.println(productListReq.toString());
        PageInfo list =productService.list(productListReq);
        return ApiRestResponse.success(list);
    }

}
