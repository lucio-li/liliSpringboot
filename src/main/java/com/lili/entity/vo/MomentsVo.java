package com.lili.entity.vo;

import com.lili.entity.moments.Comments;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by liqiao on 2018/10/10.
 * 接受moments的vo
 */
@Data
public class MomentsVo {
    /**
     * 动态的id
     */
    private String id;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 内容详情
     */
    private String content;

    /**
     * 地理位置
     */
    private String location;

    /**
     * 头像
     */
    private String headImg;


    /**
     * 附件图片列表
     */
    private List<String> attachmentList;
    /**
     * 评论列表
     */
    private List<Comments> commentsList;
}
