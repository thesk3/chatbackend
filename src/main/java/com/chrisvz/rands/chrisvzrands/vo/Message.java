package com.chrisvz.rands.chrisvzrands.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "message")
public class Message {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "text")
	private String text;
	
	@Column(name = "from_msg")
	private int fromMsg;
	
	@Column(name = "to_msg")
	private int toMsg;
	
	@Transient
	private boolean isUserMsg;

	//@Column(name = "created_datetime")
	@Transient
	private Date createdDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getFromMsg() {
		return fromMsg;
	}

	public void setFromMsg(int fromMsg) {
		this.fromMsg = fromMsg;
	}

	public int getToMsg() {
		return toMsg;
	}

	public void setToMsg(int toMsg) {
		this.toMsg = toMsg;
	}

	public boolean isUserMsg() {
		return isUserMsg;
	}

	public void setUserMsg(boolean isUserMsg) {
		this.isUserMsg = isUserMsg;
	}

	public Message( String text, int fromMsg, int toMsg, boolean isUserMsg,Date date) {
		super();
		//this.id = id;
		this.text = text;
		this.fromMsg = fromMsg;
		this.toMsg = toMsg;
		this.isUserMsg = isUserMsg;
		this.createdDate= date;
		
	}
	public Message( ) {
		
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", text=" + text + ", fromMsg=" + fromMsg + ", toMsg=" + toMsg + ", isUserMsg="
				+ isUserMsg + "]";
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}
