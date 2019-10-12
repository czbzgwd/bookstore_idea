package com.atguigu.bookstore.web;

import java.util.List;

public class page1<T> {
    //当前页
    private int pageNo;
    //当前页list
    private List<T> list;
    //每页显示记录数
    private int pageSize = 3;
    //总记录数
    private int totalNum;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    //获取总页数
    public int getTotalPageNum() {
        if (totalNum % pageSize == 0) {
            return totalNum / pageSize;
        } else {
            return (totalNum / pageSize) + 1;
        }
    }

    //上一页
    public int getPrePage() {
        int prePage = pageNo - 1;
        return prePage < 1 ? pageNo : pageNo - 1;
    }

    //下一页
    public int getNextPage(){
        int nextPage = pageNo + 1;
        return nextPage > getTotalPageNum()?getTotalPageNum():pageNo + 1;
    }

}
