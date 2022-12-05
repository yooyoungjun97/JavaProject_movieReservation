package com.java.util;

import java.util.UUID;

public class IdenticalNumberGenerator {
	public static String getIdenticalNumber() {
		String uuid = UUID.randomUUID().toString();		
		uuid = uuid.replace("-", "").substring(0,9);
		
		return uuid;
	}
	
}
