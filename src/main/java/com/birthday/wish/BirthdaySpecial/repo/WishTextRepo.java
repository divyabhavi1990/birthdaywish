package com.birthday.wish.BirthdaySpecial.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.birthday.wish.BirthdaySpecial.UserLogin.entities.WishText;

public interface WishTextRepo extends JpaRepository<WishText, Integer>{

}
