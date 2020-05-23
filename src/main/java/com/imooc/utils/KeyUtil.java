package com.imooc.utils;

import java.util.Random;

/**
 * @Description:
 * @Source: JDK 1.8
 * @author: ZhangXiaoxin
 * @date: 2019/3/3$ 19:50$
 * @Since: 1.0
 */
public class KeyUtil {
    /**
     * 生成唯一的主键
     *
     * @return
     */
    public  static synchronized  String getUniqueKey(){
        Random random = new Random();

        Integer number = random.nextInt(900000)+100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
