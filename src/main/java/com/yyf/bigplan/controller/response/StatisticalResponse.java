package com.yyf.bigplan.controller.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author 杨宇飞 2020-01-01 9:58 上午
 * @version 1.0
 * @apiNote <p>统计结果返回值</p>
 */
@ApiModel
@Data
@Builder
public class StatisticalResponse {

    // 购买前行为
    @ApiModelProperty(value = "购买前行为：玩手机", position = 1)
    private int buyBPhone;

    @ApiModelProperty(value = "购买前行为：聊天", position = 2)
    private int buyBChat;

    @ApiModelProperty(value = "购买前行为：发呆", position = 3)
    private int buyBThink;

    @ApiModelProperty(value = "购买前行为：浏览商品", position = 4)
    private int buyBLook;

    @ApiModelProperty(value = "购买前行为：检查优惠", position = 5)
    private int buyBCheck;

    @ApiModelProperty(value = "购买前行为：其他", position = 6)
    private int buyBOther;

    // 年龄
    @ApiModelProperty(value = "年龄：小学生", position = 7)
    private int age1;

    @ApiModelProperty(value = "年龄：中学生", position = 8)
    private int age2;

    @ApiModelProperty(value = "年龄：大学生", position = 9)
    private int age3;

    @ApiModelProperty(value = "年龄：青年", position = 10)
    private int age4;

    @ApiModelProperty(value = "年龄：中年", position = 11)
    private int age5;

    @ApiModelProperty(value = "年龄：老年", position = 12)
    private int age6;

    // 性别
    @ApiModelProperty(value = "性别：男性", position = 13)
    private int male;

    @ApiModelProperty(value = "年龄：女性", position = 14)
    private int female;

    // 时间段
    @ApiModelProperty(value = "时间段：上午9点-12点", position = 15)
    private int time1;

    @ApiModelProperty(value = "时间段：中午12点-3点", position = 16)
    private int time2;

    @ApiModelProperty(value = "时间段：下午3点-6点", position = 17)
    private int time3;

    @ApiModelProperty(value = "时间段：下午6点-晚间9点", position = 18)
    private int time4;

    // 等待时间
    @ApiModelProperty(value = "等待时间：30s", position = 19)
    private int wait1;

    @ApiModelProperty(value = "等待时间：60s", position = 20)
    private int wait2;

    @ApiModelProperty(value = "等待时间：90s", position = 21)
    private int wait3;

    @ApiModelProperty(value = "等待时间：120s", position = 22)
    private int wait4;

    @ApiModelProperty(value = "等待时间：160s", position = 23)
    private int wait5;

    @ApiModelProperty(value = "等待时间：160s+", position = 24)
    private int wait6;

    // 有效时间
    @ApiModelProperty(value = "有效时间：30s", position = 25)
    private int eff1;

    @ApiModelProperty(value = "有效时间：60s", position = 26)
    private int eff2;

    @ApiModelProperty(value = "有效时间：90s", position = 27)
    private int eff3;

    @ApiModelProperty(value = "有效时间：120s", position = 28)
    private int eff4;

    @ApiModelProperty(value = "有效时间：160s", position = 29)
    private int eff5;

    @ApiModelProperty(value = "有效时间：160s+", position = 30)
    private int eff6;

}
