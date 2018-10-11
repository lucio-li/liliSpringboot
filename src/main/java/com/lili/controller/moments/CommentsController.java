package com.lili.controller.moments;

import com.lili.common.dto.ServiceResponse;
import com.lili.entity.moments.Comments;
import com.lili.service.CommentsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 朋友圈的评论的controller
 * Created by lq on 2017/12/13.
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {
    @Resource
    private CommentsService commentsService;

    /**
     *
     * @param comments
     * 新增评论
     * @return
     */
    @PostMapping("add")
    public ServiceResponse add(@RequestBody Comments comments) {
        return commentsService.addOne(comments);
    }

    /**
     * 删除一条动态
     */
    @RequestMapping("deleteOne")
    public String deleteOne(HttpServletResponse response, String id) {
//        if (id == null || "".equals(id.trim())) {
////            ResponseUtils.renderJson(response, "{\"result\": \"fail\"}");
//            return null;
//        }
//        String result = commentsService.deleteOne(Integer.valueOf(id));
////        ResponseUtils.renderJson(response, "{\"result\": \"" + result + "\"}");
        return null;
    }
}
