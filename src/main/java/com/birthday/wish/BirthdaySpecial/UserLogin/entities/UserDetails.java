package com.birthday.wish.BirthdaySpecial.UserLogin.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
@Entity
@Table(name ="userdetails")
public class UserDetails {
	
	
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="userid")
	private Integer userId;
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "password")
	private String password;
	
   @OneToOne(fetch = FetchType.LAZY,
	            cascade =  CascadeType.ALL,
	            mappedBy = "userdetails")
	    private UserProfilePicture userProfile;

public Integer getUserId() {
	return userId;
}

public void setUserId(Integer userId) {
	this.userId = userId;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}


public UserProfilePicture getUserProfile() {
	return userProfile;
}

public void setUserProfile(UserProfilePicture userProfile) {
	this.userProfile = userProfile;
}
   
   

}
