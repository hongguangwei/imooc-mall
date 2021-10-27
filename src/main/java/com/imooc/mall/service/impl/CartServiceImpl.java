package com.imooc.mall.service.impl;

import com.imooc.mall.common.Constant;
import com.imooc.mall.exception.ImoocMallException;
import com.imooc.mall.exception.ImoocMallExceptionEnum;
import com.imooc.mall.model.dao.CartMapper;
import com.imooc.mall.model.dao.ProductMapper;
import com.imooc.mall.model.pojo.Cart;
import com.imooc.mall.model.pojo.Product;
import com.imooc.mall.model.vo.CartVO;
import com.imooc.mall.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author honggw
 * @create 2021-10-25 15:32
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    CartMapper cartMapper;
    @Override
    public List<CartVO> add(Integer userId, Integer productId, Integer count){
        validProduct(productId,count);
        Cart cart = cartMapper.selectCartByUserIdAndProductId(userId, productId);
        if(cart == null){
           cart = new Cart();
           cart.setProductId(productId);
           cart.setUserId(userId);
           cart.setQuantity(count);
           cart.setSelected(Constant.Cart.CHECKED);
           cartMapper.insertSelective(cart);
        }else{
            //这个商品已经在购物车里，则数量需要叠加
            count = count + cart.getQuantity();
            Cart cartNew = new Cart();
            cartNew.setQuantity(count);
            cartNew.setUserId(cart.getUserId());
            cartNew.setProductId(cart.getProductId());
            cartNew.setId(cart.getId());
            cartNew.setSelected(Constant.Cart.CHECKED);
            cartMapper.updateByPrimaryKeySelective(cartNew);
        }
        return null;
    }

    private void validProduct(Integer productId, Integer count) {
        Product product = productMapper.selectByPrimaryKey(productId);
        if(product == null||product.getStatus().equals(Constant.SaleStatus.NOT_SALE)){
            throw new ImoocMallException(ImoocMallExceptionEnum.NOT_SALE);
        }
        if(count > product.getStock()){
            throw new ImoocMallException(ImoocMallExceptionEnum.NOT_ENOUGH);
        }
    }


}
