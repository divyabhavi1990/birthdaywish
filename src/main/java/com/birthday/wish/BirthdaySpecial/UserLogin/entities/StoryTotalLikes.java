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
@Table(name = "storytotallikes")
public class StoryTotalLikes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "storyid")
	private Integer storyid;
	
	@Column(name = "imageid")
	private Integer imageid;
	
	@Column(name = "totallikes")
	private Integer totalLikes;

	public Integer getStoryid() {
		return storyid;
	}

	public void setStoryid(Integer storyid) {
		this.storyid = storyid;
	}

	public Integer getImageid() {
		return imageid;
	}

	public void setImageid(Integer imageid) {
		this.imageid = imageid;
	}

	public Integer getTotalLikes() {
		return totalLikes;
	}

	public void setTotalLikes(Integer totalLikes) {
		this.totalLikes = totalLikes;
	}
	
	
	

}
