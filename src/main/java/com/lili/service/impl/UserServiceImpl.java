package com.lili.service.impl;


import com.lili.common.dto.ServiceResponse;
import com.lili.dao.moments.UserDao;
import com.lili.entity.moments.User;
import com.lili.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    /**
     * 日志记录
     */
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public ServiceResponse queryAll() {
        ServiceResponse ajaxResult = ServiceResponse.createError();
        try {
            List<User> userList  = userDao.selectAll();
            ajaxResult = ServiceResponse.createBySuccessMsgData("查询成功", userList);

        } catch (Exception e) {
            logger.error("查询用户列表失败", e.getMessage());
        }

        return ajaxResult;
    }
    @Override
    public ServiceResponse saveOrUpdateUser(User user) {
        ServiceResponse response = null;
        try {
            User userInDB = userDao.queryOne(user.getOpenid());
            if (userInDB == null) {
                userDao.insertOne(user);
            } else {
                userDao.updateOne(user);
            }
            response = ServiceResponse.createSuccessByData("插入更新用户成功");
        }catch (Exception e) {
            logger.error("插入用户失败", e.getMessage());
            response = ServiceResponse.createErrorByData("插入更新用户成功");
        }
        return response;
        
    }

    @Override
    public ServiceResponse deleteOne(User user) {
        ServiceResponse serviceResponse = ServiceResponse.createError();
        try {
            User userInDB = userDao.queryOne(user.getOpenid());
            if (userInDB != null) {
                userDao.deleteOne(user);
                serviceResponse = ServiceResponse.createSuccessByData("删除用户成功");
            } else {
                serviceResponse = ServiceResponse.createErrorByData("用户不存在");
            }
        } catch (Exception e) {
            logger.error("删除用户失败");
        }
        return serviceResponse;

    }
	public ServiceResponse queryOne(String openid) {
        ServiceResponse serviceResponse = ServiceResponse.createError();
        try {
            User user = (User)userDao.queryOne(openid);
            serviceResponse = ServiceResponse.createSuccessByData(user);
        } catch (Exception e) {
            logger.error("查询用户失败");
        }
		// TODO Auto-generated method stub
        return serviceResponse;
		
	}
}
