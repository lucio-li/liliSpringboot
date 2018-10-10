package com.lili.dao.moments;


import com.lili.entity.moments.User;

import java.util.List;

/**
 * Created by lq on 2017/12/10.
 */
public interface UserDao {
    List<User> selectAll();
    void insertOne(User user);
    void updateOne(User user);
    void deleteOne(User user);
    User queryOne(String openid);
    List<String> queryAvatarUrlList();
}
