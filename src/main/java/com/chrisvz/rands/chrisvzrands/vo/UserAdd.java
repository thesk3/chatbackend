package com.chrisvz.rands.chrisvzrands.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_chat_list")
public class UserAdd {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "user_id")
	private long userID;
	
	@Column(name = "list_id")
	private long listID;
	
	@Column(name = "name")
	private String name;
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public long getListID() {
		return listID;
	}
	public void setListID(long listID) {
		this.listID = listID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "UserAdd [userID=" + userID + ", listID=" + listID + ", name=" + name + "]";
	}
	public UserAdd(long l, long m, String name) {
		super();
		this.userID = l;
		this.listID = m;
		this.name = name;
	}
	public UserAdd() {
		
	}

	
}
