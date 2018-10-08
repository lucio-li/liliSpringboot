package com.lili.service.impl;

import com.lili.dao.MomentsDao;
import com.lili.entity.moments.Moments;
import com.lili.service.UploadService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.UnsupportedEncodingException;

@Service(value="UploadService")
public class UploadServiceImpl implements UploadService {
	@Resource
    private MomentsDao momentsMapper;

	/**
	 * 上传照片前的数据插入数据库
	 * @param moments
	 * @return 文件夹路径
	 */
	public String addContent(Moments moments) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		//String time = moments.getTime();
		File file = new File(this.getClass().getResource("/").getPath());
		String destDirectory = file.getParentFile().getParentFile().getParent() + "/images/" + moments.numberDataTime();
		File directory = new File(destDirectory);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		moments.setDirectory(destDirectory);
		momentsMapper.insertOne(moments);
		return destDirectory;
	}

	public void uploadImage() {
		// TODO Auto-generated method stub
		
	}

}
