package com.lili.service.impl;


import com.lili.dao.UserDao;
import com.lili.entity.moments.User;
import com.lili.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lq on 2017/12/10.
 */
@Service(value="userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    public List<User> queryAll() {
        List<User> userList = null;
        userList = userDao.selectAll();
        return userList;
    }

    public void insertOne(User user) {
    	User userInDB;
    	userInDB = userDao.queryOne(user.getOpenid());
    	if (userInDB == null) {
            userDao.insertOne(user);
    	}
        
    }
    public void updateOne(User user) {
        User userInDB;
        userInDB = userDao.queryOne(user.getOpenid());
        if (userInDB == null) {
            userDao.insertOne(user);
        } else {
            userDao.updateOne(user);
        }

    }
    public void deleteOne(User user) {
        User userInDB;
        userInDB = userDao.queryOne(user.getOpenid());
        System.out.println("openid" + user.getOpenid());
        if (userInDB != null) {
            userDao.deleteOne(user);
        }

    }
	public User queryOne(String openid) {
		// TODO Auto-generated method stub
		return (User)userDao.queryOne(openid);
		
	}
}
