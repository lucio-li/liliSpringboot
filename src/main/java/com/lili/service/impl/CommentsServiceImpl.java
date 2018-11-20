package com.lili.service.impl;


import com.lili.common.dto.ServiceResponse;
import com.lili.common.util.UUIDUtil;
import com.lili.dao.moments.CommentsDao;
import com.lili.entity.moments.Comments;
import com.lili.service.CommentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by lq on 2017/12/13.
 */
@Service(value="commentsService")
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    private CommentsDao commentsDao;
    private static final Logger logger = LoggerFactory.getLogger(MomentsServiceImpl.class);

    @Override
    public ServiceResponse addOne(Comments comments) {
        ServiceResponse serviceResponse = ServiceResponse.createError();
        try{
            String id = UUIDUtil.getUUID();
            comments.setId(id);
            comments.setStatus(1);
            comments.setUpdateUser(comments.getCreator());
            commentsDao.insertOne(comments);
            serviceResponse = ServiceResponse.createSuccessByData("插入评论成功");
        } catch (Exception e) {
            logger.error("插入评论失败", e.getMessage());

        }
        return serviceResponse;


    }

    /**
     * 删除一条记录，状态改为0
     * @param id
     * @return
     */
    @Override
    public ServiceResponse deleteOne(String id) {
        ServiceResponse serviceResponse = ServiceResponse.createError();
        try {
            commentsDao.deleteById(id);
            serviceResponse = ServiceResponse.createByCodeMsg(0, "删除成功");
        } catch (Exception e){
            logger.error("删除评论失败", e.getMessage());
        }

        return serviceResponse;

    }
}
