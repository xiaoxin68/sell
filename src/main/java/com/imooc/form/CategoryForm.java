package com.imooc.form;

import lombok.Data;

/**
 * @Description:
 * @Source: JDK 1.8
 * @author: ZhangXiaoxin
 * @date: 2019/3/11$ 13:35$
 * @Since: 1.0
 */
@Data
public class CategoryForm {
    /** id */
    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}
