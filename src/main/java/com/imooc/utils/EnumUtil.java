package com.imooc.utils;

import com.imooc.enums.CodeEnum;

/**
 * @Description:枚举的工具类
 * @Source: JDK 1.8
 * @author: ZhangXiaoxin
 * @date: 2019/3/9$ 10:59$
 * @Since: 1.0
 */
public class EnumUtil {
     /*<T extends CodeEnum>对T作说明，表示继承自CodeEnum这个枚举*/
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for (T each : enumClass.getEnumConstants()){
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
