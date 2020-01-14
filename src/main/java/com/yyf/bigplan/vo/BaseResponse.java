package com.yyf.bigplan.vo;

import com.yyf.bigplan.enums.HttpStatusEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 杨宇飞 2019-11-22 12:26 上午
 * @version 1.0
 * @apiNote <p>基础返回实体类</p>
 */
@Data
public class BaseResponse<T> implements Serializable {

    /**
     * 状态码
     */
    private int code;

    /**
     * 信息
     */
    private String msg;

    /**
     * 数据
     */
    private T info;

    public void getOKRes(T t) {
        this.code = HttpStatusEnum.OK.getCode();
        this.msg = HttpStatusEnum.OK.getMsg();
        this.info = t;
    }

    public void getErrorRes() {
        this.code = HttpStatusEnum.ERROR.getCode();
        this.msg = HttpStatusEnum.ERROR.getMsg();
    }

    public void getEmptyOKRes() {
        this.code = HttpStatusEnum.OK.getCode();
        this.msg = HttpStatusEnum.OK.getMsg();
        this.info = null;
    }

}
