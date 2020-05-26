package com.birthday.wish.BirthdaySpecial.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.birthday.wish.BirthdaySpecial.UserLogin.entities.UserLikes;

public interface TotalLikesRepo extends JpaRepository<UserLikes, Integer>{
	
	@Query("SELECT u FROM UserLikes u where u.userid =:userid")
	List<UserLikes> findByUserId(@Param("userid")Integer userid);

}
