package com.lili.dao.moments;

import com.lili.entity.moments.Attachment;
import feign.Param;

import java.util.List;

/**
 * Created by liqiao on 2018/10/13.
 */
public interface AttachmentDao {
    void insert(Attachment attachment);

    /**
     * 通过moments的id 查找附件的id列表
     * @param momentsId
     * @return
     */
    List<String> queryIds(@Param("momentsId") String momentsId);

    /**
     * 获取附件信息
     */
    Attachment getById(@Param("id")String id);
}
