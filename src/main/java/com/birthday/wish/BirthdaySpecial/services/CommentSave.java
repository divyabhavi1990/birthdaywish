package com.birthday.wish.BirthdaySpecial.services;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CommentSave {
	
	private Integer userid;
	private Integer imageid;
	private List<String> comments;
	private String username;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getImageid() {
		return imageid;
	}
	public void setImageid(Integer imageid) {
		this.imageid = imageid;
	}
	public List<String> getComments() {
		return comments;
	}
	public void setComments(List<String> comments) {
		this.comments = comments;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
	

}
