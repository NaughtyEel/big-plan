package com.yyf.bigplan.enums;

/**
 * @author 杨宇飞 2019-11-22 12:36 上午
 * @version 1.0
 * @apiNote <p>Http 状态码枚举</p>
 */
public enum HttpStatusEnum {

    OK(200, "成功"),
    NONEXISTENT(404, "地址不存在"),
    ERROR(500, "服务器内部错误");

    private int code;

    private String msg;

    HttpStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
