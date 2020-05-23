package com.imooc.handler;

import com.imooc.VO.ResultVO;
import com.imooc.config.ProjectUrlConfig;
import com.imooc.exception.SellException;
import com.imooc.exception.SellerAuthorizeException;
import com.imooc.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description:
 * @Source: JDK 1.8
 * @author: ZhangXiaoxin
 * @date: 2019/3/13$ 8:38$
 * @Since: 1.0
 */
@ControllerAdvice
public class SellerExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    //拦截登录异常
    //@org.springframework.web.bind.annotation.ExceptionHandler
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException(){
        //应该跳转到扫码登录的http://t238997p11.qicp.vip/sell/wechat/qrAuthorize?returnUrl=http://t238997p11.qicp.vip/sell/seller/login
        //但是不可以，所以跳转到http://t238997p11.qicp.vip/sell/wechat/authorize?returnUrl=http://t238997p11.qicp.vip/sell/seller/login  【微信授权登录】
        //或者直接 http://t238997p11.qicp.vip/sell/seller/login

        //如果openAppId参数可用，正常情况下应该是这样的，但是那个账号不可用
       return new ModelAndView("redirect:".concat(projectUrlConfig.getWechatOpenAuthorize())
                .concat("/sell/wechat/qrAuthorize")
                .concat("?returnUrl=")
                .concat(projectUrlConfig.getSell())
                .concat("/sell/seller/login"));
    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellException(SellException e){
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }
}
