package com.lili.service.impl;

import com.lili.common.dto.ServiceResponse;
import com.lili.common.util.UUIDUtil;
import com.lili.dao.moments.AttachmentDao;
import com.lili.entity.moments.Attachment;
import com.lili.service.AttachmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by liqiao on 2018/10/13.
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {
    @Value("${imgPath}")
    private String imgPath;

    @Autowired
    private AttachmentDao attachmentDao;

    private static final Logger logger = LoggerFactory.getLogger(MomentsServiceImpl.class);

    @Override
    public ServiceResponse add(MultipartFile file, String momentsId) {
        ServiceResponse serviceResponse = ServiceResponse.createError();
        try {
            File imgDistory = new File(imgPath);
            if (!imgDistory.exists()) {
                imgDistory.mkdirs();
            }
            /**
             * 先保存完文件
             */
            String uuid = UUIDUtil.getUUID();
            String filename = file.getOriginalFilename();
            String fileType = filename.substring(filename.lastIndexOf(".") + 1);
            String filepath = imgPath + "/" + uuid + "." + fileType;
            File fillDest = new File(filepath);
            file.transferTo(fillDest);

            /**
             * 再保存进数据库
             */
            Attachment attachment = new Attachment();
            attachment.setId(uuid);
            attachment.setFilename(filename);
            attachment.setMomentsId(momentsId);
            attachment.setSize(file.getSize());
            attachment.setType(fileType);
            attachment.setStatus(1);
            attachmentDao.insert(attachment);
            serviceResponse = ServiceResponse.createSuccessByData(attachment.getId());

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("上传文件失败", e.getMessage());

        }
        return serviceResponse;
    }

    @Override
    public Attachment getById(String id) {
        Attachment attachment = null;
        try {
            attachment = attachmentDao.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("插入文件失败", e.getMessage());
        }

        return attachment;
    }
}
