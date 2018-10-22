package com.lili.controller.moments;

import com.lili.common.dto.ServiceResponse;
import com.lili.entity.moments.Comments;
import com.lili.service.CommentsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    @PutMapping("/{id}")
    public ServiceResponse deleteOne(@PathVariable("id") String id) {

        return commentsService.deleteOne(id);
    }
}
