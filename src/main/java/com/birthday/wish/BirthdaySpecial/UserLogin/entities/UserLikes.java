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
@Table(name = "userlikes")
public class UserLikes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "storydetailsid")
	private Integer storydetailsid;
	
	@Column(name = "userid")
	private Integer userid;
	
	@Column(name = "imageid")
	private Integer imageid;

	public Integer getStorydetailsid() {
		return storydetailsid;
	}

	public void setStorydetailsid(Integer storydetailsid) {
		this.storydetailsid = storydetailsid;
	}

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
	
	
	
	
	

}
