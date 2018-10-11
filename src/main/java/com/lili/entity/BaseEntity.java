package com.lili.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by liqiao on 2018/10/8.
 */
@Data
public class BaseEntity implements Serializable {
    /**
     * 主键
     */
    private String id;
    /**
     * 状态 1正常，0不可用
     */
    private int status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private String updateUser;
}
