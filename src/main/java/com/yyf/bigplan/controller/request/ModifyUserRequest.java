package com.yyf.bigplan.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 杨宇飞 2019-12-27 2:49 下午
 * @version 1.0
 * @apiNote <p>修改对象请求</p>
 */
@ApiModel
@Data
public class ModifyUserRequest {

    @ApiModelProperty(value = "对象Id", position = 1)
    private String modifyId;

    @ApiModelProperty(value = "等待时间", position = 2)
    private int modifyWaitTime;

    @ApiModelProperty(value = "有效时间", position = 3)
    private int modifyEffTime;

    @ApiModelProperty(value = "消费金额", position = 4)
    private int modifySpend;

    @ApiModelProperty(value = "删除标记", position = 5)
    private int modifyDelete;

}
