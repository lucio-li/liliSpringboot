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
    /**
     * 查询全部动态
     * @param pageForm
     * @return
     */
    Page queryAll(PageForm pageForm);

    /**
     * 删除一个动态
     * @param id
     * @return
     */
    ServiceResponse deleteOne(String id);

    /**
     * 插入一条新的动态
     * @param moments
     * @return
     */
    ServiceResponse insertOne(Moments moments);
}
