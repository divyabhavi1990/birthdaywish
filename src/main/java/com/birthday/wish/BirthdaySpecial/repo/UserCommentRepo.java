package com.birthday.wish.BirthdaySpecial.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.birthday.wish.BirthdaySpecial.UserLogin.entities.UserComments;

public interface UserCommentRepo extends JpaRepository<UserComments, Integer> {
	

}
