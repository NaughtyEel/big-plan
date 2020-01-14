package com.yyf.bigplan.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 杨宇飞 2019-11-23 5:21 上午
 * @version 1.0
 * @apiNote <p>记录地点数据传输类</p>
 */
@Data
public class PlaceDTO implements Serializable {
    private Integer id;
    private String name;
    private String imgUrl;
}
