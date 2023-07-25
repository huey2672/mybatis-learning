package com.huey.learning.java.mybatis.plus.pagination;

public abstract class PageClientObject {

    private static final long serialVersionUID = 1L;

    private int pageNum = 1;
    private int pageSize = 10;
    private int pageCount = 1;

    public PageClientObject() {
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}