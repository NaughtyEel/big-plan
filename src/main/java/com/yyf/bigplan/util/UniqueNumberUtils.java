package com.yyf.bigplan.util;

import java.io.Serializable;
import java.util.Random;
import java.util.UUID;

/**
 * @author 杨宇飞 2019-12-19 10:03 上午
 * @version 1.0
 * @apiNote <p>生成唯一编号工具</p>
 */
public class UniqueNumberUtils implements Serializable {

    /**
     * 获取用户对象的唯一编号
     * 规则: U + uuid + 记录地点id
     *
     * @return str 编号内容
     */
    public static String getUserNumber(Integer placeId) {
        return "U" + UUID.randomUUID().toString().substring(0, 8) + placeId.toString() + getRandomChar();
    }

    /**
     * 获取用户对象的组队的唯一编号
     * 规则: T + uuid + 记录地点id + 随机英文字符 + 组队人数
     *
     * @return str 编号内容
     */
    public static String getUserTeamNumber(Integer placeId, Integer teamNum) {
        return "T" + UUID.randomUUID().toString().substring(0, 8) + placeId.toString() + getRandomChar() + teamNum;
    }

    private static char getRandomChar() {
        char[] charArr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        Random r = new Random();
        int sub = r.nextInt(charArr.length);
        return charArr[sub];
    }

    public static void main(String[] args) {
        System.out.println(getUserTeamNumber(1, 3));
    }

}
