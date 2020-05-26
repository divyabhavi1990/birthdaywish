package com.birthday.wish.BirthdaySpecial.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.birthday.wish.BirthdaySpecial.UserLogin.entities.UploadData;

public interface UploadRepo  extends JpaRepository<UploadData, Integer>{

}
