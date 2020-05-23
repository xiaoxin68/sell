package com.imooc.dto;

import lombok.Data;

/**
 * @Description:
 * @Source: JDK 1.8
 * @author: ZhangXiaoxin
 * @date: 2019/3/3$ 20:01$
 * @Since: 1.0
 */
@Data
public class CartDTO {
    /*商品id*/
    private String productId;

    /*数量*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
