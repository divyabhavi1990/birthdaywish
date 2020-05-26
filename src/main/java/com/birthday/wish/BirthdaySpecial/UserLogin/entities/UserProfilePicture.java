package com.birthday.wish.BirthdaySpecial.UserLogin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
@Entity
@Table(name = "userpicture")
public class UserProfilePicture {
	@Id
	@Column(name ="profileimage")
	private String profileimage;
	@Column(name ="imagepath")
	private String imagepath;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userid", nullable = false)
    private UserDetails userdetails;

	public String getProfileimage() {
		return profileimage;
	}

	public void setProfileimage(String profileimage) {
		this.profileimage = profileimage;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	
	public void setUserdetails(UserDetails userdetails) {
		this.userdetails = userdetails;
	}
	

	
}
