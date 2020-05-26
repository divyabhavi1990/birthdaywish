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
@Table(name = "wishtext")
public class WishText {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "wishtextid")
	private Integer wishtextid;
	
	@Column(name = "userid")
	private Integer userid;
	
	@Column(name = "wishmessage")
	private String text;

	@Column(name = "username")
	private String username; 
	
	public Integer getWishtextid() {
		return wishtextid;
	}

	public void setWishtextid(Integer wishtextid) {
		this.wishtextid = wishtextid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
