package com.yyf.bigplan.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 杨宇飞 2019-12-19 4:37 下午
 * @version 1.0
 * @apiNote <p>条件查询所有User 对象并分页请求对象</p>
 */
@ApiModel
@Data
public class FindPageUserRequest {

    @ApiModelProperty(value = "页数", position = 1)
    public int currentPage;

    @ApiModelProperty(value = "页面显示条数", position = 2)
    public int pageSize;

    @ApiModelProperty(value = "用户编号", position = 3)
    public String uuid;

    @ApiModelProperty(value = "用户组队的编号", position = 4)
    public String teamUuid;

    @ApiModelProperty(value = "组队人数", position = 5)
    public int teamNum;

    @ApiModelProperty(value = "有效时间开始", position = 6)
    private int effectiveTimeStart;

    @ApiModelProperty(value = "有效时间结束", position = 7)
    private int effectiveTimeEnd;

    @ApiModelProperty(value = "等待时间开始", position = 8)
    private int waitTimeStart;

    @ApiModelProperty(value = "等待时间结束", position = 9)
    private int waitTimeEnd;

    @ApiModelProperty(value = "花费左区间", position = 10)
    private int spendStart;

    @ApiModelProperty(value = "花费右区间", position = 11)
    private int spendEnd;

    @ApiModelProperty(value = "购买前行为", position = 12)
    private String buyBehavior;

    @ApiModelProperty(value = "穿着", position = 13)
    private String wearingFeatures;

    @ApiModelProperty(value = "外貌特征", position = 14)
    private String looksFeatures;

    @ApiModelProperty(value = "属性特征", position = 15)
    private String attributeFeatures;

    @ApiModelProperty(value = "性别", position = 16)
    private int sex;

}
