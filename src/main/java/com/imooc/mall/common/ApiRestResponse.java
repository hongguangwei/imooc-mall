package com.imooc.mall.common;

import com.imooc.mall.exception.ImoocMallExceptionEnum;
import org.omg.CORBA.CODESET_INCOMPATIBLE;

/**
 * @author honggw
 * @create 2021-09-13 16:11
 * 通用的返回对象
 */
public class ApiRestResponse<T> {

    private Integer status;

    private String mag;

    private T data;

    private static final int OK_CODE = 10000;

    private static  final String OK_MSG = "SUCCESS";

    public ApiRestResponse(Integer status, String mag, T data) {
        this.status = status;
        this.mag = mag;
        this.data = data;
    }

    public ApiRestResponse(Integer status, String mag) {
        this.status = status;
        this.mag = mag;
    }

    public ApiRestResponse() {
        this(OK_CODE, OK_MSG);
    }

    public static <T> ApiRestResponse<T> success(){
        return new ApiRestResponse<>();
    }

    public static <T> ApiRestResponse<T> success(T result){
        ApiRestResponse<T> response = new ApiRestResponse<>();
        response.setData(result);
        return response;
    }

    public static <T> ApiRestResponse<T> error(ImoocMallExceptionEnum ex){
        return new ApiRestResponse<>(ex.getCode(), ex.getMsg());

    }

    public static <T> ApiRestResponse<T> error(Integer code, String mag){
        return new ApiRestResponse<>(code, mag);

    }

    @Override
    public String toString() {
        return "ApiRestResponse{" +
                "status=" + status +
                ", mag='" + mag + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static int getOkCode() {
        return OK_CODE;
    }

    public static String getOkMsg() {
        return OK_MSG;
    }
}
