package com.lili.dao.moments;


import com.lili.core.PageForm;
import com.lili.entity.moments.Moments;
import com.lili.entity.vo.MomentsVo;
import feign.Param;

import java.util.List;

public interface MomentsDao {
	List<MomentsVo> queryAll(@Param("pageForm")PageForm pageForm);
    void insertOne(Moments moments);
    int deleteOne(String time);
    int selectCount();
}
