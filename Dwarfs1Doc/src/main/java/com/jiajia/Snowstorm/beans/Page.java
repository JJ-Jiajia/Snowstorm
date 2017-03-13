package com.jiajia.Snowstorm.beans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jim on 17-3-12.
 */
public class Page<T> implements Serializable {

    private static final long serialVersionUID = 3584872572949466764L;

    //每页多少条记录
    private int pageSize;

    //当前是第几页数据
    private int currentPage;

    //一共多少条记录
    private int totalRecord;

    //一共多少页
    private int totalPage;

    //要显示的数据
    private List<T> dataList;

    public Page(List<T> list,int pageSize,int currentPage) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalRecord = list.size();
        this.totalPage = list.size()/pageSize;
        if(list.size()%pageSize !=0){
            this.totalPage+=1;
        }

        this.dataList = list.subList((currentPage-1)*pageSize,currentPage*pageSize>totalPage?totalPage:currentPage*pageSize);
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
