package com.lili.service;

import com.lili.common.dto.ServiceResponse;
import com.lili.core.Page;
import com.lili.core.PageForm;
import com.lili.entity.moments.Moments;

/**
 * 朋友圈动态的接口服务
 * Created by lq on 2017/12/13.
 */
public interface MomentsService {
    Page queryAll(PageForm pageForm);

    String deleteOne(String time);

    ServiceResponse insertOne(Moments moments);
}
