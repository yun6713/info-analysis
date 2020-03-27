package com.bonc.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "qq_info_01",type="info")
public class InfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id//spring-data id标记
	private String id;
	private String date;
	private String info;
	private String flag;
	
	public InfoEntity() {}

	public InfoEntity(String id, String date, String info, String flag) {
		super();
		this.id = id;
		this.date = date;
		this.info = info;
		this.flag = flag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
}
