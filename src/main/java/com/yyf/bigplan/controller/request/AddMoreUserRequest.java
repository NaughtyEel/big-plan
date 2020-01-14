package com.yyf.bigplan.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author 杨宇飞 2019-12-15 9:41 上午
 * @version 1.0
 * @apiNote <p>新增多个用户请求DTO</p>
 */
@ApiModel
@Data
public class AddMoreUserRequest {

    @ApiModelProperty(value = "记录地点ID", position = 1)
    private int placeId;

    @ApiModelProperty(value = "组队人数", position = 2)
    private int teamNumber;

    @ApiModelProperty(value = "有效时间", position = 3)
    private int effectiveTime;

    @ApiModelProperty(value = "等待时间", position = 4)
    private int waitTime;

    @ApiModelProperty(value = "花费", position = 5)
    private int spend;

    @ApiModelProperty(value = "购买前行为", position = 6)
    private List<String> buyBehavior;

    @ApiModelProperty(value = "购买前行为其他项", position = 7)
    private String buyBehaviorOther;

    @ApiModelProperty(value = "穿着", position = 8)
    private List<String> wearingFeatures;

    @ApiModelProperty(value = "穿着其他项", position = 9)
    private String wearingOther;

    @ApiModelProperty(value = "属性特征", position = 10)
    private List<String> attributeFeature;

    @ApiModelProperty(value = "性别", position = 11)
    private List<String> sexValues;

    @ApiModelProperty(value = "年龄", position = 12)
    private List<String> ageValues;

    @ApiModelProperty(value = "职业", position = 13)
    private List<String> occupationValues;

    @ApiModelProperty(value = "体态特征", position = 14)
    private List<String> looksFeatures;

}
