package com.lili.entity.moments;

import com.lili.entity.BaseEntity;
import lombok.Data;

import java.util.List;

/**
 * lq
 * 动态的实体类
 */
@Data
public class Moments extends BaseEntity {


	/**
	 * 动态的内容
	 */
	private String content;
	/**
	 * 地址
	 */
	private String location;



	private List<String> imageUrlLlist;
	private List<Comments> commentsList;
//	public String numberDataTime() {
//		return this.time.replaceAll("\\D", "");
//	}

}
