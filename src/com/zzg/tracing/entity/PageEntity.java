package com.zzg.tracing.entity;


public class PageEntity {

    //所有页数
    private int totalPage;
    //当前页数
    private int currentPage;
    //列表
    private Object mlist;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public Object getMlist() {
        return mlist;
    }

    public void setMlist(Object mlist) {
        this.mlist = mlist;
    }
}
