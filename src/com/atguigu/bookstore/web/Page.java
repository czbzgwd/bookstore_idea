package com.atguigu.bookstore.web;

import java.util.List;

/**
 * 2019��1��6������11:12:15
 *
 */
public class Page<T> {
	// ��ǰ�ڼ�ҳ
	private int pageNo;
	// ��ǰҳ��list
    private List<T> list;
    //ÿҳ��ʾ��������¼
    private int pageSize = 3;
    //�ܹ���������¼
    private long totalItemNumber;
    //������Ҫ��pageNo���г�ʼ��
	public Page(int pageNo) {
		super();
		this.pageNo = pageNo;
	}
	
	//��ҪУ��
	public int getPageNo() {
		if(pageNo < 0){
			pageNo = 1;
		}
		if(pageNo>getTotalPageNumber()){
			pageNo = getTotalPageNumber();
		}
		return pageNo;
	}
	
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setList(List<T> list) {
		this.list = list;
	}
	public List<T> getList() {
		return list;
	}
	//��ȡ��ҳ��
	private int getTotalPageNumber(){
		int totalPageNumber = (int)totalItemNumber / pageSize;
		if(totalItemNumber % pageSize != 0){
			totalPageNumber++;
		}
		return totalPageNumber;
	}
	public void setTotalItemNumber(long totalItemNumber) {
		this.totalItemNumber = totalItemNumber;
	}
	//�ж��Ƿ�����һҳ
	public boolean isHasNext(){
		if(getPageNo() < getTotalPageNumber()){
			return true;
		}
		return false;
	}
	//�ж��Ƿ�����һҳ
	public boolean isHasPrev(){
		if(getPageNo()>1){
			return true;
		}
		return false;
	}
	//��ȡ��һҳ
	public int getNextPage(){
		/*if(getPageNo() == 1 ){
			return getPageNo();
		}*/
		if(isHasNext()){
			return getPageNo()+1;
		}
		return getPageNo();
	}
	//��ȡ��һҳ
	public int getPrevPage(){
		if(isHasPrev()){
			return getPageNo()-1;
		}
		return getPageNo();
	}
    
}
