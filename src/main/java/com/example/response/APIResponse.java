package com.example.response;


import com.alibaba.fastjson.annotation.JSONField;
import com.example.enums.ResultCode;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fjy on 2018/4/19.
 */
@Getter
@ToString
public class APIResponse<T> implements Serializable {
    private static final long serialVersionUID = 6789847341345973718L;

    public static final APIResponse<?> OK = new APIResponse<>();

    private int code;

    private String message;

    private String description;

    private T data;

    private Object[] args; // 返回信息中替换的参数

    public APIResponse() {
        this(ResultCode.OK.getValue());
    }

    public APIResponse(int code) {
        this.code = code;
    }

    public APIResponse(ResultCode resultCode) {
        this.code = resultCode.getValue();
    }

    public APIResponse<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public APIResponse<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public APIResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public APIResponse<T> setDescription(String description) {
        this.description = description;
        return this;
    }

    public APIResponse<T> setArgs(Object... args) {
        this.args = args;
        return this;
    }

    @JsonIgnore
    @JSONField(serialize = false, deserialize = false)
    public Object[] getArgs() {
        return args;
    }

    @JsonIgnore
    @JSONField(serialize = false, deserialize = false)
    public boolean isSuccess() {
        return this.code == ResultCode.OK.getValue();
    }

    /**
     * 对于只需要返回list，不需要返回pageNo、pageSize的请求，简单的封装一下
     * @param list
     * @return
     */
    public static <T> APIResponse<Page<T>> page(List<T> list) {
        APIResponse<Page<T>> response = new APIResponse<>();
        Page<T> page = new Page<>();
        page.setList(list);
        response.setData(page);
        return response;
    }

    public static <T> APIResponse<T> success(T data) {
        APIResponse<T> response = new APIResponse<>();
        response.setData(data);
        return response;
    }

    public static <T> APIResponse<T> error(int code, Object... args) {
        APIResponse<T> response = new APIResponse<>();
        response.setCode(code);
        response.setArgs(args);
        return response;
    }

    public static <T> APIResponse<T> error(int code, String message) {
        APIResponse<T> response = new APIResponse<>();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

    public static <T> APIResponse<Page<T>> page(List<T> list, Integer total) {
        APIResponse<Page<T>> response = new APIResponse<>();
        Page<T> page = new Page<>();
        page.setTotal(total);
        page.setList(list);
        response.setData(page);
        return response;
    }
}
