package com.lili.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lili.dao.moments.MomentsDao;
import com.lili.entity.moments.Moments;
import com.lili.service.MomentsService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lq on 2017/12/13.
 */
@Service(value="momentsService")
public class MomentsServiceImpl implements MomentsService {
    @Resource
    private MomentsDao momentsDao;
    private Logger logger = Logger.getLogger(MomentsServiceImpl.class);
    public String queryAll() throws JsonProcessingException {
        try{
            List<Moments> momentsList = momentsDao.queryAll();
            for (int i = 0, len = momentsList.size(); i < len; i++) {
                Moments moments = momentsList.get(i);
                String directoryPath = moments.getDirectory();
                String imageUrl = "https://lq555.cn/images/" + moments.numberDataTime() +"/";//文件夹名字
                System.out.println(moments.numberDataTime());
                File directory = new File(directoryPath);
                String filename = "";
                List<String> imageUrlList = new ArrayList<String>();
                if (directory.exists()) {
                    File file[] = directory.listFiles();
                    for (int j = 0; j < file.length; j++) {
                        filename = imageUrl + file[j].getName();
                        imageUrlList.add(filename);
                    }
                }

                moments.setImageUrlLlist(imageUrlList);
            }
            ObjectMapper mapper = new ObjectMapper();
            String momentsJson = mapper.writeValueAsString(momentsList);
            List<String> avatarUrlList = momentsDao.queryAvatarUrlList();
            if(avatarUrlList.size() == 1) {
                avatarUrlList.add(avatarUrlList.get(0));
            } else if(avatarUrlList.size() == 0) {
                avatarUrlList.add("https://wx.qlogo.cn/mmopen/vi_32/lwy6Y5ybTj1iaJw8ic7l6vXriaHyXOPAlGeknINSOgAG8qAGRSKFJCLicxPAicdMrp3XibKXiapBLHAVKpDeibCRKhDJxA/0");
                avatarUrlList.add("https://wx.qlogo.cn/mmopen/vi_32/lwy6Y5ybTj1iaJw8ic7l6vXriaHyXOPAlGeknINSOgAG8qAGRSKFJCLicxPAicdMrp3XibKXiapBLHAVKpDeibCRKhDJxA/0");
            }
            String avatarUrlListJson = mapper.writeValueAsString(avatarUrlList);
            return "{\"momentsList\":" + momentsJson + ",\"avatarUrlList\":" + avatarUrlListJson + "}";

        } catch (Exception e) {
            e.printStackTrace();
            return "{\"momentsList\":[],\"avatarUrlList\":''}";

        }


    }

    public String deleteOne(String time) {
        logger.info("测试log");
        int a = momentsDao.deleteOne(time);
        if (a == 0) {
            return "fail";//删除失败
        } else {
            return "success";//删除成功
        }


    }
}
