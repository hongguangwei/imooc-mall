package com.imooc.mall.controller;

import com.imooc.mall.common.ApiRestResponse;
import com.imooc.mall.filter.UserFilter;
import com.imooc.mall.model.vo.CartVO;
import com.imooc.mall.service.CartService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author honggw
 * @create 2021-10-21 15:52
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;
    @PostMapping("add")
    @ApiOperation("添加商品到购物车")
    public ApiRestResponse add(@RequestParam Integer productId, @RequestParam Integer count){
        List<CartVO> cartVOList = cartService.add(UserFilter.currentUser.getId(), productId, count);
        return ApiRestResponse.success(cartVOList);
    }

    @GetMapping("list")
    @ApiOperation("购物车列表")
    public ApiRestResponse list(){
        //内部用户获取用户id，防止横向越权
        List<CartVO> cartVOList = cartService.list(UserFilter.currentUser.getId());
        return ApiRestResponse.success(cartVOList);
    }

    @PostMapping("update")
    @ApiOperation("更新购物车")
    public ApiRestResponse update(@RequestParam  Integer productId, Integer count){
        List<CartVO> cartVOList = cartService.update(UserFilter.currentUser.getId(), productId, count);
        //内部用户获取用户id，防止横向越
        return ApiRestResponse.success(cartVOList);
    }

    @PostMapping("delete")
    @ApiOperation("删除购物车")
    public ApiRestResponse delete(@RequestParam Integer productId){
        List<CartVO> cartVOList = cartService.delete(UserFilter.currentUser.getId(), productId);
        //内部用户获取用户id，防止横向越
        return ApiRestResponse.success(cartVOList);
    }

    @PostMapping("select")
    @ApiOperation("选中/不选中购物车")
    public ApiRestResponse select(@RequestParam Integer productId, @RequestParam Integer selected){
        List<CartVO> cartVOList = cartService.selectOrNot(UserFilter.currentUser.getId(), productId,selected);
        //内部用户获取用户id，防止横向越
        return ApiRestResponse.success(cartVOList);
    }

    @PostMapping("selectAll")
    @ApiOperation("全选中/不选中购物车")
    public ApiRestResponse selectAllOrNot( @RequestParam Integer selected){
        List<CartVO> cartVOList = cartService.selectAllOrNot(UserFilter.currentUser.getId(), selected);
        //内部用户获取用户id，防止横向越
        return ApiRestResponse.success(cartVOList);
    }


}
