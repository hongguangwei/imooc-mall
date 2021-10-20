package com.imooc.mall.model.request;

/**
 * @author honggw
 * @create 2021-10-12 10:35
 */
public class ProductListReq {

    private String keyword;

    private Integer categoryId;

    private Integer pageNum = 1;

    private Integer pageSize = 10;

    private String orderBy;

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "ProductListReq{" +
                "keyword='" + keyword + '\'' +
                ", categoryId=" + categoryId +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", orderBy='" + orderBy + '\'' +
                '}';
    }
}
