package com.lili.dao.moments;


import com.lili.entity.moments.Moments;
import com.lili.entity.vo.MomentsVo;

import java.util.List;

public interface MomentsDao {
	List<MomentsVo> queryAll();
    void insertOne(Moments moments);
    int deleteOne(String time);
}
