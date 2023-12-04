package edu.njnu.eamsbe.utils;


import lombok.Getter;
import lombok.Setter;

/**
 * 封装返回结果
 *
 * @param <T>
 */
@Getter
@Setter
public class Result<T> {
    private static final int SUCCESS_CODE = 200;
    private int code;
    private T data;
    private String msg;

    public Result(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static <T> Result<T> getSuccessResult(T data) {
        return new Result<>(SUCCESS_CODE, data, "success");
    }

    public static <T> Result<T> getFailResult(int code, String msg) {
        return new Result<>(code, null, msg);
    }


}
