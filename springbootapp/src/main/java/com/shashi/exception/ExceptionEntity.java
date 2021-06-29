package com.shashi.exception;

import java.util.Date;

public class ExceptionEntity {
	
	private Date dateTime;
	private String msg;
	private String desc;
	
	public ExceptionEntity(Date dateTime, String msg, String desc) {
		super();
		this.dateTime = dateTime;
		this.msg = msg;
		this.desc = desc;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
