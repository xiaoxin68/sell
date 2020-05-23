package com.imooc.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Source: JDK 1.8
 * @author: ZhangXiaoxin
 * @date: 2019/3/5$ 19:34$
 * @Since: 1.0
 */
public interface LoginService {

    public void doWxLogin(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
