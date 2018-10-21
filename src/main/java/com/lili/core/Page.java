package com.lili.core;

import java.io.Serializable;
import java.util.List;

/**
 * 描述:
 ** 分页数据
 * 1.分页数据的类型为E
 * @author Yangjinming
 * @create 2018-03-30 下午2:28
 */

public final class Page<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -3892651904973825978L;
    /**
     * 总记录数
     */
    private int totalRecordCount;
    /**
     * 当前页数
     */
    private int currentPage = 1 ;
    /**
     * 每页展现的数据量
     */
    private int pageSize = 10 ;
    /**
     * 总页数
     */
    private int totalPageCount;
    /**
     * 数据
     */
    private List<T> datas;

    public Page() {
        super();
    }

    public Page(int currentPage, int pageSize) {
        super();
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public Page(int totalRecordCount, int currentPage, int pageSize, List<T> datas) {
        super();
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalRecordCount = totalRecordCount;
        this.datas = datas;
    }

    public int getTotalRecordCount() {
        return totalRecordCount;
    }

    public void setTotalRecordCount(int totalRecordCount) {
        this.totalRecordCount = totalRecordCount;
    }

    public int getTotalPageCount() {
        totalPageCount = (totalRecordCount % pageSize > 0)?totalRecordCount/pageSize+1:totalRecordCount/pageSize;
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount){
        this.totalPageCount =  totalPageCount;
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

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}
