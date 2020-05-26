package com.birthday.wish.BirthdaySpecial.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.birthday.wish.BirthdaySpecial.UserLogin.entities.StoryTotalLikes;

public interface StorytotalLikesRepo extends JpaRepository<StoryTotalLikes, Integer>{
	
	
	@Query("SELECT u FROM StoryTotalLikes u where u.imageid =:imageid")
	StoryTotalLikes findByImageId(@Param("imageid")Integer imageid);
	
	@Query("SELECT u FROM StoryTotalLikes u")
	List<StoryTotalLikes> findTotalLikes();

}
