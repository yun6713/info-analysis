package com.bonc.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
/**
 * 索引、类型自动创建。手动：PUT ADDR/index，创建索引；POST ADDR/index/type/_mapping body，创建type<br/>
 * 定制分词器等，@Field标记，指定类型、分词器等信息。<br/>
 * http查询：POST /index/type/_search queryBody<br/>
 * http删除：POST /index/type/_delete_by_query body<br/>
 * 验证分词器：POST /_analyze {analyzer, text}
 * 
 * @author litianlin
 * @date   2020年3月30日下午2:52:33
 * @Description TODO
 */
@Document(indexName = "qq_info_01",type="info")
public class InfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String _id;
	@Field(type=FieldType.Text,analyzer="ik_max_word", searchAnalyzer="ik_max_word")
	private String date;
	@Field(type=FieldType.Text,analyzer="ik_max_word", searchAnalyzer="ik_max_word")
	private String info;
	@Field(type=FieldType.Keyword)
	private String flag;
	
	public InfoEntity() {}
	
	public InfoEntity(String info) {
		if(info==null) return;
		int loc = info.indexOf("\n");
		if(loc>0) {
			this.date=info.substring(0,  loc);
			this.info=info.substring(loc+1);
		}else {
			this.date=info;
			this.info=info;
		}
		
	}

	public InfoEntity(String id, String date, String info, String flag) {
		super();
		this._id = id;
		this.date = date;
		this.info = info;
		this.flag = flag;
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		this._id = id;
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

	@Override
	public String toString() {
		return "InfoEntity [_id=" + _id + ", date=" + date + ", info=" + info + ", flag=" + flag + "]";
	}
	
	
}
