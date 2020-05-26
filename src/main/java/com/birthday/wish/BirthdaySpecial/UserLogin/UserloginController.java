package com.birthday.wish.BirthdaySpecial.UserLogin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.birthday.wish.BirthdaySpecial.UserLogin.entities.UserLikes;
import com.birthday.wish.BirthdaySpecial.UserLogin.entities.StoryTotalLikes;
import com.birthday.wish.BirthdaySpecial.UserLogin.entities.UploadData;
import com.birthday.wish.BirthdaySpecial.UserLogin.entities.UserComments;
import com.birthday.wish.BirthdaySpecial.UserLogin.entities.UserDetails;
import com.birthday.wish.BirthdaySpecial.UserLogin.entities.WishText;
import com.birthday.wish.BirthdaySpecial.exception.CustomException;
import com.birthday.wish.BirthdaySpecial.services.CommentSave;
import com.birthday.wish.BirthdaySpecial.services.UserServices;
import com.birthday.wish.BirthdaySpecial.util.AllCommentsResult;
import com.birthday.wish.BirthdaySpecial.util.BirthdayConstants;
import com.birthday.wish.BirthdaySpecial.util.BirthdayUtil;


@RestController
@Validated
public class UserloginController {
	
	@Autowired
	UserServices userService;
	
	
	@GetMapping("/user/username/{username}/password/{password}")
	public ResponseEntity<Object> isUserPresent(@PathVariable(value = "username")String username, @PathVariable(value = "password") String password)
	{
		
		try
		{
		UserDetails user=userService.isUSerPresentCheck(username, password);
		return ResponseEntity.status(200).body(user);
		}
		catch (CustomException e) {
			System.out.println(e);
			return  e.birthdayCustomeException();
		}
	    catch (Exception e) {
			try {
				System.out.println(e);
				throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,
						BirthdayConstants.COMMON_ERROR_MESSAGE);
			} catch (CustomException ex) {
				System.out.println(ex);
				return ex.birthdayCustomeException();
			}
		}
	    
		
		
	}
	
	@PostMapping("/saveblob/")
	public ResponseEntity<Object> saveBlob(@RequestBody UploadData upload)
	{
	
	    try
	    {
	    	if(upload!=null)
		    {
		    userService.saveUserData(upload) ;
		    }
	    }
		catch (CustomException e) {
			return  e.birthdayCustomeException();
		}
	    catch (Exception e) {
			try {
				System.out.println(e);
				throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,
						BirthdayConstants.COMMON_ERROR_MESSAGE);
			} catch (CustomException ex) {
				System.out.println(ex);
				return ex.birthdayCustomeException();
			}
		}
	  
	    return BirthdayUtil.returnMessage(HttpStatus.CREATED,
				BirthdayConstants.SUCCESS);
		
		
	}
	
	@PostMapping("/savewish/")
	public ResponseEntity<Object> saveBlob(@RequestBody WishText wishes)
	{
		
	    try
	    {
	    	if(wishes!=null)
		    {
		    userService.saveWishes(wishes) ;
		    }
	    }
		catch (CustomException e) {
			System.out.println(e);
			return  e.birthdayCustomeException();
		}
	    catch (Exception e) {
			try {
				System.out.println(e);
				throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,
						BirthdayConstants.COMMON_ERROR_MESSAGE);
			} catch (CustomException ex) {
				System.out.println(ex);
				return ex.birthdayCustomeException();
			}
		}
	  
	    return BirthdayUtil.returnMessage(HttpStatus.CREATED,
				BirthdayConstants.SUCCESS);
		
		
	}
	
	
	@PostMapping("/totallikes/")
	public ResponseEntity<Object> SaveLikes(@RequestBody UserLikes likes)
	{
		
	    try
	    {
	    	if(likes!=null)
		    {
		    userService.saveLikes(likes) ;
		    }
	    }
		catch (CustomException e) {
			System.out.println(e);
			return  e.birthdayCustomeException();
		}
	    catch (Exception e) {
			try {
				System.out.println(e);
				throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,
						BirthdayConstants.COMMON_ERROR_MESSAGE);
			} catch (CustomException ex) {
				System.out.println(ex);
				return ex.birthdayCustomeException();
			}
		}
	  
	    return BirthdayUtil.returnMessage(HttpStatus.CREATED,
				BirthdayConstants.SUCCESS);
		
		
	}
	
	@GetMapping("/userLike/userid/{userid}")
	public ResponseEntity<Object> getLikedImages(@PathVariable(value = "userid")Integer userid)
	{
		
		try
		{
			System.out.println("userid00"+userid);
		List<UserLikes> likes=userService.getuserLikes(userid);
		return ResponseEntity.status(200).body(likes);
		}
		catch (CustomException e) {
			System.out.println(e);
			return  e.birthdayCustomeException();
		}
	    catch (Exception e) {
			try {
				System.out.println(e);
				throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,
						BirthdayConstants.COMMON_ERROR_MESSAGE);
			} catch (CustomException ex) {
				System.out.println(ex);
				return ex.birthdayCustomeException();
			}
		}
	    
		
		
	}
	
	
	@PostMapping("/savecomments")
	public ResponseEntity<Object> saveComments(@RequestBody CommentSave comments)
	{
		
	    try
	    {
	    	if(comments!=null)
		    {
		    userService.saveComment(comments) ;
		    }
	    }
		catch (CustomException e) {
			System.out.println(e);
			return  e.birthdayCustomeException();
		}
	    catch (Exception e) {
			try {
				System.out.println(e);
				throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,
						BirthdayConstants.COMMON_ERROR_MESSAGE);
			} catch (CustomException ex) {
				System.out.println(ex);
				return ex.birthdayCustomeException();
			}
		}
	  
	    return BirthdayUtil.returnMessage(HttpStatus.CREATED,
				BirthdayConstants.SUCCESS);
		
		
	}
	
	
	@GetMapping("/loadstory")
	public ResponseEntity<Object> gteComments()
	{
		
		try
		{
		List<UserComments> usercomments=userService.getcomments();
		
		return ResponseEntity.status(200).body(usercomments);
		}
		catch (CustomException e) {
			System.out.println(e);
			return  e.birthdayCustomeException();
		}
	    catch (Exception e) {
			try {
				System.out.println(e);
				throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,
						BirthdayConstants.COMMON_ERROR_MESSAGE);
			} catch (CustomException ex) {
				System.out.println(ex);
				return ex.birthdayCustomeException();
			}
		}
	    
		
		
	}
	
	@GetMapping("/getwishes/")
	public ResponseEntity<Object> getAllWishes()
	{
		
		try
		{
		 List<UploadData> data=userService.getwishes();
		return ResponseEntity.status(200).body(data);
		}
		catch (CustomException e) {
			System.out.println(e);
			return  e.birthdayCustomeException();
		}
	    catch (Exception e) {
			try {
				System.out.println(e);
				throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,
						BirthdayConstants.COMMON_ERROR_MESSAGE);
			} catch (CustomException ex) {
				System.out.println(ex);
				return ex.birthdayCustomeException();
			}
		}
	    
		
		
	}
	
	@GetMapping("/gettotallikes/")
	public ResponseEntity<Object> getlikes()
	{
		
		try
		{
		 List<StoryTotalLikes> data=userService.getLikesFromdb();
		return ResponseEntity.status(200).body(data);
		}
		catch (CustomException e) {
			System.out.println(e);
			return  e.birthdayCustomeException();
		}
	    catch (Exception e) {
			try {
				System.out.println(e);
				throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,
						BirthdayConstants.COMMON_ERROR_MESSAGE);
			} catch (CustomException ex) {
				System.out.println(ex);
				return ex.birthdayCustomeException();
			}
		}
	    
		
		
	}
	
	
	@GetMapping("/getwishtext/")
	public ResponseEntity<Object> getwishText()
	{
		
		try
		{
		 List<WishText> data=userService.getWisshtext();
		return ResponseEntity.status(200).body(data);
		}
		catch (CustomException e) {
			System.out.println(e);
			return  e.birthdayCustomeException();
		}
	    catch (Exception e) {
			try {
				System.out.println(e);
				throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,
						BirthdayConstants.COMMON_ERROR_MESSAGE);
			} catch (CustomException ex) {
				System.out.println(ex);
				return ex.birthdayCustomeException();
			}
		}
	    
		
		
	}
	

}
