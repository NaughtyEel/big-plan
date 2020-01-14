package com.yyf.bigplan.config;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * @author 杨宇飞 2020-01-10 5:06 上午
 * @version 1.0
 * @apiNote <p>数据库字符集配置</p>
 */
public class MySQL5InnoDBDialectUtf8mb4 extends MySQL5InnoDBDialect {
    @Override
    public String getTableTypeString() {
        return "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_general_ci";
    }
}