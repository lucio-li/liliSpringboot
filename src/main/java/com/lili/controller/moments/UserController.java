package com.lili.controller.moments;


import com.lili.common.dto.ServiceResponse;
import com.lili.common.util.HttpRequestUtils;
import com.lili.entity.moments.User;
import com.lili.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lq on 2017/12/11.
 */
@RestController
@RequestMapping("/server/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/add")
    public ServiceResponse  add(@RequestBody User user){
        if (user == null || user.getOpenid() == null) {
            return ServiceResponse.createError();
        }
        return userService.saveOrUpdateUser(user);
    }
    @RequestMapping("/delete")
    public ServiceResponse  delete(@RequestBody User user){
        if (user == null || user.getOpenid() == null) {
            return ServiceResponse.createError();
        }
        return userService.deleteOne(user);
    }

    @RequestMapping("/getOpenid")
    public String  getOpenid(HttpServletRequest request, HttpServletResponse response){

        String js_code = request.getParameter("js_code");
        String appid = request.getParameter("appid");
        String secret = request.getParameter("secret");
        String grant_type = request.getParameter("grant_type");
        String str = "js_code=" + js_code + "&appid=" + appid + "&secret=" + secret + "&grant_type=" + grant_type;
        String openid = HttpRequestUtils.sendGet("https://api.weixin.qq.com/sns/jscode2session", str);
        System.out.println("openid:" + openid);
//        ResponseUtils.renderJson(response, openid);
        return openid;
    }
}
