package com.imooc.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.imooc.dataobject.ProductInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:商品vo(包含类目)
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: ${date}
 * @Since: 1.0
 */
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = 7097863777546530545L;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
