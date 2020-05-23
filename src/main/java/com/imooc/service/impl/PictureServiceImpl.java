package com.imooc.service.impl;

import com.imooc.config.ImageServerConfig;
import com.imooc.service.PictureService;
import com.imooc.utils.FtpUtil;
import com.imooc.utils.KeyUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Source: JDK 1.8
 * @author: ZhangXiaoxin
 * @date: 2019/3/11$ 10:58$
 * @Since: 1.0
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private ImageServerConfig imageServerConfig;

    @Override
    public Map uploadPicture(MultipartFile uploadFile) {
        Map resultMap = new HashMap<>();
        try {
            //生成一个新的文件名
            //取原始文件名
            String oldName = uploadFile.getOriginalFilename();
            //生成新文件名
            //UUID.randomUUID();
            String newName = KeyUtil.getUniqueKey();
            newName = newName + oldName.substring(oldName.lastIndexOf("."));
            //图片上传
            String imagePath = new DateTime().toString("/yyyy/MM/dd");
            boolean result = FtpUtil.uploadFile(imageServerConfig.getAddress(), imageServerConfig.getPort(), imageServerConfig.getUsername(), imageServerConfig.getPassword(),
                    imageServerConfig.getBastPath(), imagePath, newName, uploadFile.getInputStream());
            //返回结果
            if(!result) {
                resultMap.put("error", 1);
                resultMap.put("message", "文件上传失败");
                return resultMap;
            }
            resultMap.put("error", 0);
            resultMap.put("url", imageServerConfig.getImageBaseUrl() + imagePath + "/" + newName);
            return resultMap;

        } catch (Exception e) {
            resultMap.put("error", 1);
            resultMap.put("message", "文件上传发生异常");
            return resultMap;
        }
    }
}
