package com.imooc.mall.model.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author honggw
 * @create 2021-09-18 10:08
 */
public class AddCategoryReq {

    @Size(min = 2,max = 5)
    @NotNull(message = "name不能为null")
    private String name;

    @NotNull
    @Max(3)
    private Integer type;

    @NotNull
    private Integer parentId;

    @NotNull
    private Integer orderNum;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
}
