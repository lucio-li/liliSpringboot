package com.lili.service;


import com.lili.common.dto.ServiceResponse;
import com.lili.entity.moments.Comments;

/**
 * 朋友圈动态的接口服务
 * Created by lq on 2017/12/13.
 */
public interface CommentsService {
    ServiceResponse addOne(Comments comments);
    ServiceResponse deleteOne(int id);
}
