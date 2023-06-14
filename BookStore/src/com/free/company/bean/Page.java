package com.free.company.bean;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int pageNo;
	private int totalPageNo;
	private int totalRecord;
	public static final int PAGE_SIZE = 4;
	private List<T> list;

	public int getPageNo() {
		if(pageNo < 1){
			return 1;
		}
		if(pageNo > getTotalPageNo()){
			return getTotalPageNo();
		}
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	public int getTotalPageNo() {
		return totalRecord % PAGE_SIZE == 0 ? totalRecord / PAGE_SIZE : totalRecord / PAGE_SIZE + 1;
	}
	public void setTotalPageNo(int totalPageNo) {
		this.totalPageNo = totalPageNo;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public Page(int pageNo, int totalPageNo, int totalRecord, List<T> list) {
		super();
		this.pageNo = pageNo;
		this.totalPageNo = totalPageNo;
		this.totalRecord = totalRecord;
		this.list = list;
	}
	public Page() {
		super();
	}
	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", totalPageNo=" + totalPageNo + ", totalRecord=" + totalRecord + ", list="
				+ list + "]";
	}

}
