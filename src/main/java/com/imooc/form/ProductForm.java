package com.imooc.form;

import com.imooc.enums.ProductStatusEnum;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description:添加商品表单提交过来的数据
 * @Source: JDK 1.8
 * @author: ZhangXiaoxin
 * @date: 2019/3/10$ 15:00$
 * @Since: 1.0
 */
@Data
public class ProductForm {

    /**  商品id */
    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 类目编号. */
    private Integer categoryType;

}
