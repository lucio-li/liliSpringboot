package com.lili.entity.moments;

import lombok.Data;

import java.util.Date;

/**
 * Created by liqiao on 2018/1/9.
 * 动态的评论的实体类
 */
@Data
public class Comments {
    private String momentsTime;
    private String name;
    private String contentDetail;
    private Date createTime;

}
