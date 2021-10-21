package com.imooc.mall.service;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.model.pojo.Category;
import com.imooc.mall.model.pojo.Product;
import com.imooc.mall.model.request.AddCategoryReq;
import com.imooc.mall.model.request.AddProductReq;
import com.imooc.mall.model.request.ProductListReq;
import com.imooc.mall.model.vo.CategoryVO;

import java.util.List;

/**
 * @author honggw
 * @create 2021-09-18 11:37
 */
public interface ProductService {

    void add(AddProductReq addProductReq);

    void upadate(Product updateProduct);

    void delete(Integer id);

    void batchUpdateSellStatus(Integer[] ids, Integer SellStatus);

    PageInfo listForAdmin(Integer pageNum, Integer pageSize);

    Product detail(Integer id);

    PageInfo list(ProductListReq productListReq);
}
