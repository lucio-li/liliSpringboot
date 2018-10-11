package com.lili.entity.moments;

import com.lili.entity.BaseEntity;
import lombok.Data;

/**
 * Created by liqiao on 2018/1/9.
 * 动态的评论的实体类
 */
@Data
public class Comments extends BaseEntity {
    /**
     * 动态的id
     */
    private String momentsId;
    /**
     * 评论的内容的详情
     */
    private String contentDetail;

    /**
     * 回复的目标人的openid
     */
    private String aimUser;

}
