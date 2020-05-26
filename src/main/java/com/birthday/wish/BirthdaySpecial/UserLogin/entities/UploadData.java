package com.birthday.wish.BirthdaySpecial.UserLogin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


@EnableAutoConfiguration
@Entity
@Table(name = "uploadwish")
public class UploadData {
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "uploadid")
	private Integer uploadid;
	
	@Column(name = "userid")
	private Integer userId;
	
	@Column(name = "videodata")
	private String blob;
	
	@Column(name = "username")
	private String username; 

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getBlob() {
		return blob;
	}

	public void setBlob(String blob) {
		this.blob = blob;
	}

	public Integer getUploadid() {
		return uploadid;
	}

	public void setUploadid(Integer uploadid) {
		this.uploadid = uploadid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	

	
	

}
