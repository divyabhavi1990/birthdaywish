package com.birthday.wish.BirthdaySpecial.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.birthday.wish.BirthdaySpecial.UserLogin.entities.StoryTotalLikes;
import com.birthday.wish.BirthdaySpecial.UserLogin.entities.UserLikes;
import com.birthday.wish.BirthdaySpecial.UserLogin.entities.UploadData;
import com.birthday.wish.BirthdaySpecial.UserLogin.entities.UserComments;
import com.birthday.wish.BirthdaySpecial.UserLogin.entities.UserDetails;
import com.birthday.wish.BirthdaySpecial.UserLogin.entities.WishText;
import com.birthday.wish.BirthdaySpecial.exception.CustomException;
import com.birthday.wish.BirthdaySpecial.repo.StorytotalLikesRepo;
import com.birthday.wish.BirthdaySpecial.repo.TotalLikesRepo;
import com.birthday.wish.BirthdaySpecial.repo.UploadRepo;
import com.birthday.wish.BirthdaySpecial.repo.UserCommentRepo;
import com.birthday.wish.BirthdaySpecial.repo.UserRepo;
import com.birthday.wish.BirthdaySpecial.repo.WishTextRepo;
import com.birthday.wish.BirthdaySpecial.util.AllCommentsResult;

@Service
public class UserServices {
	
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	UploadRepo uploadRepo;
	
	@Autowired
	WishTextRepo wishRepo;
	@Autowired
	TotalLikesRepo totallikes;
	@Autowired
	StorytotalLikesRepo storylikes;
	
	@Autowired
	UserCommentRepo usercommentRepo;
	
	public UserDetails isUSerPresentCheck(String username, String password)throws CustomException
	{
		UserDetails usert=userRepo.findByUserName(username,password);
		return usert;
	}
	
	public void saveUserData(UploadData data) throws CustomException
	{
		uploadRepo.save(data);
	}
	
	public void saveWishes(WishText data) throws CustomException
	{
		wishRepo.save(data);
	}
	
	public void saveLikes(UserLikes likes)throws CustomException
	{
		totallikes.save(likes);
		saveTotalLikes(likes.getImageid());
		
		
	}
	
	private void saveTotalLikes(Integer imageid)throws CustomException
	{
		StoryTotalLikes likes=storylikes.findByImageId(imageid);
		if(likes==null)
		{
		      likes=new StoryTotalLikes();
		      likes.setImageid(imageid);
		      likes.setTotalLikes(1);
		}
		else
		{
		
		int total=likes.getTotalLikes()+1;
		likes.setTotalLikes(total);
		}
		System.out.println("likes-"+likes.getTotalLikes());
		storylikes.save(likes);
		
	}
	
	public List<UserLikes> getuserLikes(Integer userid)throws CustomException
	{
	
		List<UserLikes> likes= totallikes.findByUserId(userid);
		return likes;
		
	}
	
	public void saveComment(CommentSave comments)throws CustomException
	{
		UserComments ucomment;
		for (String com : comments.getComments()) {
			ucomment=new UserComments();
			ucomment.setUserid(comments.getUserid());
			ucomment.setImageid(comments.getImageid());
			ucomment.setUsername(comments.getUsername());
			ucomment.setComment(com);
			usercommentRepo.save(ucomment);
		}
	}
	
	public List<UserComments> getcomments()throws CustomException
	{
		 List<UserComments> usercomments=usercommentRepo.findAll();
		 return usercomments;
	}
	
	public List<UploadData> getwishes()throws CustomException
	{
		 List<UploadData> wishes=uploadRepo.findAll();
		 System.out.println("getwishes data--"+wishes.size());	
		 return wishes;
	}
	
	public List<StoryTotalLikes> getLikesFromdb()throws CustomException
	{
		 List<StoryTotalLikes> likes=storylikes.findAll();
		 return likes;
	}
	
	public List<WishText> getWisshtext()throws CustomException
	{
		 List<WishText> text=wishRepo.findAll();
		 return text;
	}
}
