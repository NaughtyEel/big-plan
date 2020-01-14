package com.yyf.bigplan.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 杨宇飞 2019-11-20 11:29 下午
 * @version 1.0
 * @apiNote <p>观察目标用户实体类</p>
 */
@Entity
@Table(name = "user")
@Data
@Builder
@ApiModel(value = "观察目标用户实体类")
public class User implements Serializable {

    /**
     * 主键id
     */
    @Id
    @ApiModelProperty(value = "主键id", position = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 性别（0 男 1 女）
     */
    @ApiModelProperty(value = "性别（0 男 1 女）多人时用英文逗号隔开", position = 2)
    @Column(name = "sex", length = 64, columnDefinition = "varchar(64) COMMENT '性别（0 男 1 女）多人时用英文逗号隔开'")
    private String sex;

    /**
     * 年龄（0 小学生 1 中学生 2 大学生 3 青年 4 中年 5 老年）
     */
    @ApiModelProperty(value = "年龄（0 小学生 1 中学生 2 大学生 3 青年 4 中年 5 老年）多人时用英文逗号隔开", position = 3)
    @Column(name = "age", length = 64, columnDefinition = "varchar(64) COMMENT '年龄（0 小学生 1 中学生 2 大学生 3 青年 4 中年 5 " +
            "老年）多人时用英文逗号隔开'")
    private String age;

    /**
     * 职业 多人时用英文逗号隔开
     */
    @ApiModelProperty(value = "职业 多人时用英文逗号隔开", position = 4)
    @Column(name = "occupation", length = 128, columnDefinition = "varchar(128) COMMENT '职业 多人时用英文逗号隔开'")
    private String occupation;

    /**
     * 进店时间
     */
    @ApiModelProperty(value = "进店时间", position = 5)
    @Column(name = "in_time", columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP COMMENT '进店时间'", updatable = false)
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    @Generated(GenerationTime.INSERT)
    private LocalDateTime inTime;

    /**
     * 购买前行为（0 玩手机 1 聊天 2 发呆 3 浏览展品 4 检查优惠 其他）多人时取普遍行为
     */
    @ApiModelProperty(value = "购买前行为（0 玩手机 1 聊天 2 发呆 3 浏览展品 4 检查优惠 其他）多人时取普遍行为", position = 6)
    @Column(name = "buy_behavior", length = 128, columnDefinition = "varchar(128) COMMENT '购买前行为（0 玩手机 1 聊天 2 发呆 3 " +
            "浏览展品 4 检查优惠 其他）多人时取普遍行为'")
    private String buyBehavior;

    /**
     * 展区视野停留时间（单位：秒）
     */
    @ApiModelProperty(value = "展区视野停留时间（单位：秒）", position = 7)
    @Column(name = "effective_time", length = 8, columnDefinition = "int(8) COMMENT '展区视野停留时间（单位：秒)'")
    private Integer effectiveTime;


    /**
     * 等待时间（单位：秒）
     */
    @ApiModelProperty(value = "等待时间（单位：秒）", position = 8)
    @Column(name = "wait_time", length = 8, columnDefinition = "int(8) COMMENT '等待时间（单位：秒)'")
    private Integer waitTime;

    /**
     * 是否组队（0 否 1 是）
     */
    @ApiModelProperty(value = "是否组队（0 否 1 是）", position = 9)
    @Column(name = "is_team", length = 1, columnDefinition = "int(1) COMMENT '是否组队（0 否 1 是）'")
    private Integer isTeam;

    /**
     * 组队人数（默认为0）
     */
    @ApiModelProperty(value = "组队人数（默认为0）", position = 10)
    @Column(name = "team_num", length = 8, columnDefinition = "int(8) COMMENT '组队人数（默认为0）'")
    private Integer teamNum;

    /**
     * 是否购买（0 否 1 是）
     */
    @ApiModelProperty(value = "是否购买（0 否 1 是）", position = 11)
    @Column(name = "is_buy", length = 1, columnDefinition = "int(1) COMMENT '是否购买（0 否 1 是）'")
    private Integer isBuy;

    /**
     * 属性特征（0 情侣 1 外国人 2 拎着很多东西 3 家庭成员）多人时按顺序以英文逗号隔开
     */
    @ApiModelProperty(value = "属性特征（0 情侣 1 外国人 2 拎着很多东西 3 家庭成员）多人时按顺序逗号隔开", position = 12)
    @Column(name = "attribute_features", length = 128, columnDefinition = "varchar(128) COMMENT '属性特征（0 情侣 1 外国人 2 " +
            "拎着很多东西 3 家庭成员）多人时按顺序逗号隔开'")
    private String attributeFeatures;

    /**
     * 穿着特征（0 正式 1 休闲 2 华贵 3 运动 其他）多人时按顺序以英文逗号隔开
     */
    @ApiModelProperty(value = "穿着特征（0 正式 1 休闲 2 华贵 3 运动 其他）多人时按顺序以英文逗号隔开", position = 13)
    @Column(name = "wearing_features", length = 128, columnDefinition = "varchar(128) COMMENT'穿着特征（0 正式 1 休闲 2 华贵 3 " +
            "运动 其他）多人时按顺序以英文逗号隔开'")
    private String wearingFeatures;

    /**
     * 外貌特征（0 胖 1 中等身材 2 瘦）多人时按顺序以英文逗号隔开
     */
    @ApiModelProperty(value = "外貌特征（0 胖 1 中等身材 2 瘦）多人时按顺序以英文逗号隔开", position = 14)
    @Column(name = "looks_features", length = 128, columnDefinition = "varchar(128) COMMENT'外貌特征（0 胖 1 中等身材 2 " +
            "瘦）多人时按顺序以英文逗号隔开'")
    private String looksFeatures;

    /**
     * 记录地点id 不能为NULL
     */
    @ApiModelProperty(value = "记录地点id 不能为NULL", position = 15)
    @Column(name = "add_place_id", nullable = false, length = 11, columnDefinition = "int(11) COMMENT '记录地点id 不能为NULL'")
    private Integer addPlaceId;

    /**
     * 花费金额（单位：元）
     */
    @ApiModelProperty(value = "花费金额（单位：元）", position = 16)
    @Column(name = "spend", length = 11, columnDefinition = "int(11) COMMENT '花费金额（单位：元）'")
    private Integer spend;

    /**
     * 默认更新时间
     */
    @ApiModelProperty(value = "默认更新时间", position = 17)
    @Column(name = "update_time", columnDefinition = "datetime  DEFAULT CURRENT_TIMESTAMP COMMENT '默认更新时间'")
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime updateTime;

    /**
     * 用户唯一编号 不能为NULL
     */
    @ApiModelProperty(value = "用户唯一编号 不能为NULL", position = 18)
    @Column(name = "uuid", length = 64, columnDefinition = "varchar(64) NOT NULL  COMMENT '用户唯一编号 " +
            "不能为NULL'")
    private String uuid;

    /**
     * 用户组队的唯一编号
     */
    @ApiModelProperty(value = "用户组队的唯一编号", position = 19)
    @Column(name = "team_uuid", length = 64, columnDefinition = "varchar(64) COMMENT '用户组队的唯一编号'")
    private String teamUuid;

}
