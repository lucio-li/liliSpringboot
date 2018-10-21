package com.lili.entity.vo;

import lombok.Data;

/**
 * Created by liqiao on 2018/10/21.
 */
@Data
public class CommentsVo {
    /**
     * 动态的id
     */
    private String id;
    /**
     * 评论的内容的详情
     */
    private String contentDetail;

    /**
     * 回复的目标人的openid
     */
    private String aimUser;

    /**
     * 用户的名称
     */
    private String creator;
}
