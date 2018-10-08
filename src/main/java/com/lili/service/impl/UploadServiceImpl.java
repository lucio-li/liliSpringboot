package com.lili.service.impl;

import com.lili.common.dto.ServiceResponse;
import com.lili.dao.MomentsDao;
import com.lili.entity.moments.Moments;
import com.lili.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;

@Service(value="UploadService")
public class UploadServiceImpl implements UploadService {
	@Resource
    private MomentsDao momentsDao;
	/**
	 * 日志记录
	 */
	private static final Logger logger = LoggerFactory.getLogger(UploadServiceImpl.class);

	/**
	 * 上传照片前的数据插入数据库
	 * @param moments
	 * @return 文件夹路径
	 */
	public ServiceResponse addContent(Moments moments){
		// TODO Auto-generated method stub
		//String time = moments.getTime();
		ServiceResponse serviceResponse = ServiceResponse.createError();
		try {
			File file = new File(this.getClass().getResource("/").getPath());
			String destDirectory = file.getParentFile().getParentFile().getParent() + "/images/" + moments.numberDataTime();
			File directory = new File(destDirectory);
			if (!directory.exists()) {
				directory.mkdirs();
			}
			moments.setDirectory(destDirectory);
			momentsDao.insertOne(moments);
			serviceResponse = ServiceResponse.createSuccessByData(destDirectory);
		} catch (Exception e) {
			logger.error("上传文件失败");
		}
		return serviceResponse;

	}



}
