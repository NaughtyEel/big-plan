package com.yyf.bigplan.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 杨宇飞 2020-01-06 2:58 下午
 * @version 1.0
 * @apiNote <p>修改记录地点图片请求</p>
 */
@ApiModel
@Data
public class ModifyPlaceRequest {

    @ApiModelProperty(value = "记录地点Id", position = 1)
    private String modifyId;

    @ApiModelProperty(value = "图片", position = 2)
    private String file;

}
