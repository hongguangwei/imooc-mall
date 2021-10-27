package com.imooc.mall.service;

import com.imooc.mall.exception.ImoocMallException;
import com.imooc.mall.model.pojo.User;
import com.imooc.mall.model.vo.CartVO;

import java.util.List;

/**
 * @author honggw
 * @create 2021-09-07 12:00
 */
public interface CartService {


    List<CartVO> add(Integer userId, Integer productId, Integer count);
}
