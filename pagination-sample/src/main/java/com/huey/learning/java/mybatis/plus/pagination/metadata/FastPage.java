package com.huey.learning.java.mybatis.plus.pagination.metadata;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author huey
 */
public class FastPage<T> extends Page<T> {

    /**
     * 一次查询多少页数据，默认 1
     */
    private long pageCount = 1;

    /**
     *
     */
    private long origSize;

    public FastPage() {
        super();
        super.setSearchCount(false);
        this.origSize = super.getSize();
    }

    public FastPage(long current, long size) {
        this(current, size, 1);
    }

    public FastPage(long current, long size, long page) {
        super(current, size * page, false);
        this.pageCount = page;
        // 保存真实的页大小
        this.origSize = size;
    }

    @Override
    public long offset() {
        return getCurrent() > 0 ? (getCurrent() - 1) * getOrigSize() : 0;
    }

    @Override
    public boolean isSearchCount() {
        return false;
    }

    @Override
    public Page<T> setSearchCount(boolean isSearchCount) {
        throw new UnsupportedOperationException();
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public long getOrigSize() {
        return origSize;
    }

    public void setOrigSize(long origSize) {
        this.origSize = origSize;
    }

    public long getMatchedCount() {
        return getRecords() != null ? getRecords().size() : 0;
    }

}
