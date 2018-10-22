package com.lili.dao.moments;


import com.lili.entity.moments.Comments;

public interface CommentsDao {
    /**
     * 插入一条记录
     * @param comments
     */
    void insertOne(Comments comments);

    /**
     * 删除一条记录，
     * @param id
     */
    void deleteById(String id);
}
