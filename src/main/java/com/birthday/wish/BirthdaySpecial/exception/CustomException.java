package com.birthday.wish.BirthdaySpecial.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.birthday.wish.BirthdaySpecial.util.BirthdayUtil;

public class CustomException extends Exception{
	
	private HttpStatus code;
	private String message;
	
	public CustomException(HttpStatus code, String message)
	{
		super(message);
		this.code=code;
		this.message=message;
		
	}

	public ResponseEntity<Object> birthdayCustomeException(){
		return BirthdayUtil.returnMessage(code, message);
		 
		
		
	}

}
