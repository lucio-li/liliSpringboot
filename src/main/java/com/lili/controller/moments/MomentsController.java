package com.lili.controller.moments;

import com.lili.common.dto.ServiceResponse;
import com.lili.core.Page;
import com.lili.core.PageForm;
import com.lili.entity.moments.Attachment;
import com.lili.entity.moments.Moments;
import com.lili.service.AttachmentService;
import com.lili.service.MomentsService;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 朋友圈照片的展示，管理
 * Created by lq on 2017/12/13.
 */
@RestController
@RequestMapping("/moments")
public class MomentsController {
    @Resource
    private MomentsService momentsService;

    @Autowired
    private AttachmentService attachmentService;

    @Value("${imgPath}")
    private String imgPath;

    /**
     *
     * 获取所有的动态
     * @return
     */
    @RequestMapping("list")
    public Page list(PageForm pageForm) {
        return momentsService.queryAll(pageForm);
    }

    /**
     * 删除一条动态
     */
    @PutMapping("/{id}")
    public ServiceResponse deleteOne(@PathVariable("id") String id) {
        return momentsService.deleteOne(id);
    }

    /**
     * 新增一条动态
     * @param moments
     * @return
     */
    @PostMapping("add")
    public ServiceResponse add(@RequestBody Moments moments) {
        return momentsService.insertOne(moments);
    }

    /**
     * 上传文件
     */
    @PostMapping("upload")
    public ServiceResponse uploadFile(@Param("file")MultipartFile file, @Param("momentsId")String  momentsId) {
        return attachmentService.add(file, momentsId);
    }

    /**
     * 获取图片附件
     */
    @GetMapping("attach")
    public void attach(@RequestParam("attachId") String attachId, HttpServletResponse response) {
        FileInputStream fis = null;
        OutputStream os = null;
        try {
            Attachment attachment = attachmentService.getById(attachId);
            if (attachment == null) {
                return;
            }
            fis = new FileInputStream(imgPath + "/" + attachId + "." + attachment.getType());
            os = response.getOutputStream();
            int count = 0;
            byte[] buffer = new byte[1024 * 8];
            while ((count = fis.read(buffer)) != -1) {
                os.write(buffer, 0, count);
                os.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            fis.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
