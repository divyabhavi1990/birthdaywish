package com.birthday.wish.BirthdaySpecial.util;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



public class BirthdayUtil {
	
	public static ResponseEntity<Object> returnMessage(HttpStatus code, String message) {
		Map<String, Object> body = new LinkedHashMap<>();

		body.put(BirthdayConstants.TIMESTAMP, new Date());
		body.put(BirthdayConstants.STATUS, code);
		body.put(BirthdayConstants.MESSAGE, message);
		return new ResponseEntity<>(body, code);
	}
	

}
