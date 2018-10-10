package com.lili.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by liqiao on 2018/10/8.
 */
@Data
public class BaseEntity implements Serializable {
    private String status;
    private Date createTime;
    private Date updateTime;
    private String creator;
    private String updateUser;
}
