package com.lili.entity.moments;

import com.lili.entity.BaseEntity;
import lombok.Data;

/**
 * Created by liqiao on 2018/10/13.
 */
@Data
public class Attachment extends BaseEntity {
    /**
     * 附件类型
     */
    private String type;

    /**
     * 附件大小
     */
    private Long size;

    /**
     * 文件名
     */
    private String filename;

    /**
     * 动态的id
     */
    private String momentsId;
}
