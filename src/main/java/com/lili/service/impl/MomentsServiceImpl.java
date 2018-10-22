package com.lili.service.impl;


import com.lili.common.dto.ServiceResponse;
import com.lili.common.util.UUIDUtil;
import com.lili.core.Page;
import com.lili.core.PageForm;
import com.lili.dao.moments.MomentsDao;
import com.lili.dao.moments.UserDao;
import com.lili.entity.moments.Moments;
import com.lili.entity.vo.MomentsVo;
import com.lili.service.MomentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lq on 2017/12/13.
 */
@Service(value="momentsService")
public class MomentsServiceImpl implements MomentsService {
    @Autowired
    private MomentsDao momentsDao;
    private static final Logger logger = LoggerFactory.getLogger(MomentsServiceImpl.class);

    /**
     * 查询全部的动态
     * @param pageForm
     * @return
     */
    @Override
    public Page queryAll(PageForm pageForm)  {
        Page page = new Page();
        try{
            if (pageForm == null) {
                pageForm = new PageForm();
            }

            List<MomentsVo> momentsList = momentsDao.queryAll(pageForm);
            int count = momentsDao.selectCount();
            page.setCurrentPage(pageForm.getCurrentPage());
            page.setPageSize(pageForm.getPageSize());
            page.setTotalRecordCount(count);
            page.setDatas(momentsList);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return page;

    }

    /**
     * 删除动态
     * @param id
     * @return
     */
    @Override
    public ServiceResponse deleteOne(String id) {
        ServiceResponse serviceResponse = ServiceResponse.createError();
        try {
            momentsDao.deleteOne(id);
            serviceResponse  = ServiceResponse.createByCodeMsg(0, "删除成功");
        } catch (Exception e) {
            logger.error("删除动态失败",e.getMessage());
        }
        return serviceResponse;
    }

    @Override
    public ServiceResponse insertOne(Moments moments) {
        ServiceResponse response = null;
        try {
            String id = UUIDUtil.getUUID().toString();
            moments.setId(id);
            momentsDao.insertOne(moments);
            response = ServiceResponse.createSuccessByData(moments.getId());
        } catch (Exception e) {
            logger.error("插入用户失败", e.getMessage());
            response = ServiceResponse.createErrorByData("插入更新动态失败");
        }
        return response;
    }


}
