package com.yyf.bigplan.enums.classEnum;

import lombok.Data;

/**
 * @author 杨宇飞 2019-12-19 4:53 下午
 * @version 1.0
 * @apiNote <p>分页属性枚举类</p>
 */
@Data
public class PageStateEnum {

    public static int currentPage = 0; // 默认的下标index
    public static int pageSize = 10; // 默认每一页的条数

}
