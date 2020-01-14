package com.yyf.bigplan.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 杨宇飞 2020-01-08 7:24 上午
 * @version 1.0
 * @apiNote <p>删除一个记录地点请求实体</p>
 */
@ApiModel
@Data
public class DelOnePlaceRequest {

    @ApiModelProperty(value = "记录地点ID", position = 1)
    private int placeId;

}
