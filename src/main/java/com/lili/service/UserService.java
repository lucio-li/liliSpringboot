package com.lili.service;


import com.lili.common.dto.ServiceResponse;
import com.lili.entity.moments.User;

/**
 * Created by lq on 2017/12/10.
 */
public interface UserService {
    ServiceResponse queryAll();
    ServiceResponse saveOrUpdateUser(User user);
    ServiceResponse deleteOne(User user);
    ServiceResponse queryOne(String openid);
}
