package com.imooc.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Description:
 * @Source: JDK 1.8
 * @author: ZhangXiaoxin
 * @date: 2019/3/11$ 10:57$
 * @Since: 1.0
 */
public interface PictureService {

     Map uploadPicture(MultipartFile uploadFile);
}
