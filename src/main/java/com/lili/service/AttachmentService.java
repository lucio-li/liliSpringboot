package com.lili.service;

import com.lili.common.dto.ServiceResponse;
import com.lili.entity.moments.Attachment;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by liqiao on 2018/10/13.
 */
public interface AttachmentService {
    ServiceResponse add(MultipartFile file, String momentsId);
    Attachment getById(String id);
}
