package com.yyf.bigplan.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author 杨宇飞 2019-12-15 9:41 上午
 * @version 1.0
 * @apiNote <p>新增一个用户请求DTO</p>
 */
@ApiModel
@Data
public class AddOneUserRequest {

    @ApiModelProperty(value = "记录地点ID", position = 1)
    private int placeId;

    @ApiModelProperty(value = "有效时间", position = 2)
    private int effectiveTime;

    @ApiModelProperty(value = "等待时间", position = 3)
    private int waitTime;

    @ApiModelProperty(value = "花费", position = 4)
    private int spend;

    @ApiModelProperty(value = "购买前行为", position = 5)
    private List<String> buyBehavior;

    @ApiModelProperty(value = "购买前行为其他项", position = 6)
    private String buyBehaviorOther;

    @ApiModelProperty(value = "穿着", position = 7)
    private List<String> wearingFeatures;

    @ApiModelProperty(value = "体态特征", position = 8)
    private String looksFeature;

    @ApiModelProperty(value = "穿着其他项", position = 9)
    private String wearingOther;

    @ApiModelProperty(value = "属性特征", position = 10)
    private List<String> attributeFeature;

    @ApiModelProperty(value = "性别", position = 11)
    private String sexValue;

    @ApiModelProperty(value = "年龄", position = 12)
    private String ageValue;

    @ApiModelProperty(value = "职业", position = 13)
    @NotNull
    private String occupationValue;

}
