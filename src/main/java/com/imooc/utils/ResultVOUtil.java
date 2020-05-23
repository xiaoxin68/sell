package com.imooc.utils;

import com.imooc.VO.ResultVO;

/**
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: ${date}
 * @Since: 1.0
 */
public class ResultVOUtil {

    /**
     * 将成功时的方法封装
     *
     * @param object
     * @return
     */
    public  static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static  ResultVO success(){
        return success(null);
    }

    public  static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
