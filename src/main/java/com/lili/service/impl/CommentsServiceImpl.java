package com.lili.service.impl;


import com.lili.dao.CommentsDao;
import com.lili.entity.moments.Comments;
import com.lili.service.CommentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by lq on 2017/12/13.
 */
@Service(value="commentsService")
public class CommentsServiceImpl implements CommentsService {
    @Resource
    private CommentsDao commentsDao;
//    private Logger logger = Logger.getLogger(CommentsServiceImpl.class);


    public String addOne(Comments comments) {
        Date now = new Date();
        comments.setCreateTime(now);
        try{
            commentsDao.insertOne(comments);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }


    }

    public String deleteOne(int id) {
//        logger.info("测试log");
        int a = commentsDao.deleteById(id);
        if (a == 0) {
            return "fail";//删除失败
        } else {
            return "success";//删除成功
        }


    }
}
