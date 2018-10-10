package com.lili.entity.vo;

import com.lili.entity.moments.Moments;
import lombok.Data;

import java.util.List;

/**
 * Created by liqiao on 2018/10/10.
 * 接受moments的vo
 */
@Data
public class MomentsVo {
    private List<Moments> momentsList;
    private List<String> avatarUrlList;
}
