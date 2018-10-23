package com.lili.core;

import java.io.Serializable;

/**
 * 描述: 分页提交表单
 *
 * @author Yangjinming
 * @create 2018-03-30 下午2:28
 */

public final class PageForm implements Serializable{
    private static final long serialVersionUID = 179887833393695206L;
    //当前页
    private int currentPage=0;
    //每页数量
    private int pageSize=10;

    public PageForm() {
        super();
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
