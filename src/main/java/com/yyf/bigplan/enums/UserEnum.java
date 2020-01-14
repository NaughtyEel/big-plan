package com.yyf.bigplan.enums;

/**
 * @author 杨宇飞 2019-12-15 3:47 下午
 * @version 1.0
 * @apiNote <p>用户相关枚举属性</p>
 */
public enum UserEnum {
    // 删除标记
    NO_DELETE(0, "未删除"),
    IS_DELETE(1, "已删除"),
    // 是否组队
    NO_TEAM(0, "否"),
    IS_TEAM(1, "是"),
    // 购买行为
    BUY_PHONE(0, "玩手机"),
    BUY_CHAT(1, "聊天"),
    BUY_THINK(2, "发呆"),
    BUY_LOOK(3, "浏览商品"),
    BUY_CHECK(4, "检查优惠"),
    BUY_OTHER(5, "其他"),
    // 年龄
    AGE_1(0, "小学生"),
    AGE_2(1, "中学生"),
    AGE_3(2, "大学生"),
    AGE_4(3, "青年"),
    AGE_5(4, "中年"),
    AGE_6(5, "老年"),
    // 性别
    MALE(0, "男"),
    FEMALE(1, "女");


    private int code;

    private String msg;

    UserEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
