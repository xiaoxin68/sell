package com.imooc.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description:http
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: ${date}
 * @Since: 1.0
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO <T> implements Serializable {

    /*快捷键Shift+d*/
    private static final long serialVersionUID = 3068837394742385883L;

    /*错误码*/
    private Integer code;

    /*提示信息*/
    private String msg;

    /*具体内容*/
    private T data;
}
