package com.yyf.bigplan.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 杨宇飞 2019-11-19 6:25 下午
 * @version 1.0
 * @apiNote <p>记录地区实体类</p>
 */
@Entity
@Table(name = "place")
@Data
@ApiModel(value = "记录地区实体类")
@NoArgsConstructor
public class Place implements Serializable {

    /**
     * 主键id
     */
    @Id
    @ApiModelProperty(value = "主键id", position = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 记录地点
     */
    @ApiModelProperty(value = "记录地点", position = 2)
    @Column(name = "name", nullable = false, columnDefinition = "varchar(255) COMMENT '记录地点'")
    private String name;

    /**
     * 图片路径
     */
    @ApiModelProperty(value = "图片路径", position = 3)
    @Column(name = "imgURL", columnDefinition = "varchar(500) COMMENT '图片路径'")
    private String imgURL;

    /**
     * 默认创建时间
     */
    @ApiModelProperty(value = "默认创建时间", position = 4)
    @Column(name = "create_time", columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP COMMENT '默认创建时间'", updatable
            = false)
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    @Generated(GenerationTime.INSERT)
    private LocalDateTime createTime;

    /**
     * 默认更新时间
     */
    @ApiModelProperty(value = "默认更新时间", position = 5)
    @Column(name = "update_time", columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP COMMENT '默认更新时间'")
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime updateTime;
}
