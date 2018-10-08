package com.lili.service;


import com.lili.common.dto.ServiceResponse;
import com.lili.entity.moments.Moments;

import java.io.UnsupportedEncodingException;

public interface UploadService {
	//上传照片前先上传数据，动态内容，时间等
	ServiceResponse addContent(Moments moments) throws UnsupportedEncodingException;
//	ServiceResponse uploadImage();
}
