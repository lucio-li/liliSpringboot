package com.lili.entity.moments;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * lq
 * 动态的实体类
 */
@Data
public class Moments {
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 动态的内容
	 */
	private String content;
	/**
	 * 地址
	 */
	private String location;
	/**
	 * 创建人，openid
	 */
	private String creator;

	private List<String> imageUrlLlist;
	private List<Comments> commentsList;
//	public String numberDataTime() {
//		return this.time.replaceAll("\\D", "");
//	}

}
