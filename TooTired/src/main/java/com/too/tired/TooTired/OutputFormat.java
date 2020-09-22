package com.too.tired.TooTired;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class OutputFormat <T>{
	private Date timestamp;
	private int code;
	private String detail;
	private List<T> listData;
	private T data;
	public OutputFormat(int code, String detail, List<T> listData, T data) {
		this.code = code;
		this.detail = detail;
		this.listData = listData;
		this.data = data;
	}
	public String getTimestamp() {
		this.timestamp = new Date();
		return this.timestamp.toString();
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public List<T> getListData() {
		return listData;
	}
	public void setListData(List<T> listData) {
		this.listData = listData;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
