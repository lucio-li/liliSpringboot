package com.lili.entity.moments;

import lombok.Data;

import java.util.List;

/**
 * lq
 * 动态的实体类
 */
@Data
public class Moments {
	private String content;
	private String time;
	private String location;
	private String directory;
	private String avatarUrl;
	private List<String> imageUrlLlist;
	private List<Comments> commentsList;
	public String numberDataTime() {
		return this.time.replaceAll("\\D", "");
	}

}
