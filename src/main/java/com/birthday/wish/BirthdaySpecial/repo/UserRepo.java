package com.birthday.wish.BirthdaySpecial.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.birthday.wish.BirthdaySpecial.UserLogin.entities.UserDetails;

@Repository
public interface UserRepo extends JpaRepository<UserDetails,Integer>{
	
	@Query("SELECT u FROM UserDetails u where u.firstName =:username and u.password=:password")
	UserDetails findByUserName(@Param("username")String username,@Param("password")String password);

}
