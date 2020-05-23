package com.imooc.enums;

import lombok.Getter;

/**
 * @Description:订单状态
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: ${date}
 * @Since: 1.0
 */
@Getter
public enum OrderStatusEnum implements CodeEnum{
    CANCEL(2, "已取消"),
    FINISH(1, "完结"),
    NEW(0, "新订单");

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
