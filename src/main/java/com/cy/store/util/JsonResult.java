package com.cy.store.util;

import java.io.Serializable;

/**
 * 响应结果类
 * @param <E> 响应数据的类型
 */
public class JsonResult<E> implements Serializable {
    /** 状态码 */
    private Integer state;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    private Integer code;
    /** 状态描述信息 */
    private String message;
    /** 数据 */
    private E data;

    public JsonResult() {
        super();
    }


    public JsonResult(Integer state, Integer code) {
        super();
        this.state = state;
        this.code = code;
    }

    /** 出现异常时调用 */
    public JsonResult(Throwable e) {
        super();
        // 获取异常对象中的异常信息
        this.message = e.getMessage();
    }

    public JsonResult(Integer state, Integer code, E data) {
        super();
        this.state = state;
        this.data = data;
        this.code = code;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
