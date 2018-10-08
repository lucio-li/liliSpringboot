package com.lili.dao;


import com.lili.entity.moments.Moments;

import java.util.List;

public interface MomentsDao {
	List<Moments> queryAll();
    void insertOne(Moments moments);
    List<String> queryAvatarUrlList();
    int deleteOne(String time);
}
