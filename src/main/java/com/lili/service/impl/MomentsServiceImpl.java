package com.lili.service.impl;


import com.lili.common.dto.ServiceResponse;
import com.lili.common.util.UUIDUtil;
import com.lili.dao.moments.MomentsDao;
import com.lili.dao.moments.UserDao;
import com.lili.entity.moments.Moments;
import com.lili.entity.vo.MomentsVo;
import com.lili.service.MomentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lq on 2017/12/13.
 */
@Service(value="momentsService")
public class MomentsServiceImpl implements MomentsService {
    @Autowired
    private MomentsDao momentsDao;
    @Autowired
    private UserDao userDao;
    @Value("${imgpath}")
    private String imgpath;
    private static final Logger logger = LoggerFactory.getLogger(MomentsServiceImpl.class);
    public ServiceResponse queryAll()  {
        ServiceResponse serviceResponse = ServiceResponse.createError();
        try{
            MomentsVo momentsVo = new MomentsVo();
            List<Moments> momentsList = momentsDao.queryAll();
//            for (int i = 0, len = momentsList.size(); i < len; i++) {
//                Moments moments = momentsList.get(i);
//                String directoryPath = moments.getDirectory();
////                String imageUrl = "https://lq555.cn/images/" + moments.numberDataTime() +"/";//文件夹名字
//                String imageUrl = this.imgpath + moments.numberDataTime() +"/";//文件夹名字

//                File directory = new File(directoryPath);
//                String filename = "";
//                List<String> imageUrlList = new ArrayList<String>();
//                if (directory.exists()) {
//                    File file[] = directory.listFiles();
//                    for (int j = 0; j < file.length; j++) {
//                        filename = imageUrl + file[j].getName();
//                        imageUrlList.add(filename);
//                    }
//                }
//
//                moments.setImageUrlLlist(imageUrlList);
//            }
            momentsVo.setMomentsList(momentsList);
//            ObjectMapper mapper = new ObjectMapper();
//            String momentsJson = mapper.writeValueAsString(momentsList);
            List<String> avatarUrlList = userDao.queryAvatarUrlList();
//            if(avatarUrlList.size() == 1) {
//                avatarUrlList.add(avatarUrlList.get(0));
//            } else if(avatarUrlList.size() == 0) {
//                avatarUrlList.add("https://wx.qlogo.cn/mmopen/vi_32/lwy6Y5ybTj1iaJw8ic7l6vXriaHyXOPAlGeknINSOgAG8qAGRSKFJCLicxPAicdMrp3XibKXiapBLHAVKpDeibCRKhDJxA/0");
//                avatarUrlList.add("https://wx.qlogo.cn/mmopen/vi_32/lwy6Y5ybTj1iaJw8ic7l6vXriaHyXOPAlGeknINSOgAG8qAGRSKFJCLicxPAicdMrp3XibKXiapBLHAVKpDeibCRKhDJxA/0");
//            }
//            String avatarUrlListJson = mapper.writeValueAsString(avatarUrlList);
//            return "{\"momentsList\":" + momentsJson + ",\"avatarUrlList\":" + avatarUrlListJson + "}";
            momentsVo.setAvatarUrlList(avatarUrlList);
            serviceResponse = ServiceResponse.createSuccessByData(momentsList);


        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
//            return "{\"momentsList\":[],\"avatarUrlList\":''}";

        }
        return serviceResponse;

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

    @Override
    public ServiceResponse insertOne(Moments moments) {
        ServiceResponse response = null;
        try {
            String id = UUIDUtil.getUUID().toString();
            moments.setId(id);
            momentsDao.insertOne(moments);
            response = ServiceResponse.createSuccessByData("插入更新动态成功");
        } catch (Exception e) {
            logger.error("插入用户失败", e.getMessage());
            response = ServiceResponse.createErrorByData("插入更新动态失败");
        }
        return response;
    }


}
