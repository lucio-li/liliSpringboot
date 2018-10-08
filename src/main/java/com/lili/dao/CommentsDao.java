package com.lili.dao;


import com.lili.entity.moments.Comments;

public interface CommentsDao {

    void insertOne(Comments comments);
    int deleteById(int id);
}
