package com.lili.controller.moments;

import com.lili.common.dto.ServiceResponse;
import com.lili.service.MomentsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 朋友圈照片的展示，管理
 * Created by lq on 2017/12/13.
 */
@RestController
@RequestMapping("/moments")
public class MomentsController {
    @Resource
    private MomentsService momentsService;

    /**
     *
     * 获取所有的动态
     * @return
     */
    @RequestMapping("list")
    public ServiceResponse list() {
        return momentsService.queryAll();
    }

    /**
     * 删除一条动态
     */
    @RequestMapping("deleteOne")
    public String deleteOne(HttpServletResponse response, String time) {
        if (time == null || "".equals(time.trim())) {
//            ResponseUtils.renderJson(response, "{\"result\": \"fail\"}");
            return null;
        }
        String result = momentsService.deleteOne(time);
//        ResponseUtils.renderJson(response, "{\"result\": \"" + result + "\"}");
        return null;
    }
}
