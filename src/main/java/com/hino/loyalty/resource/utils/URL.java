package com.hino.loyalty.resource.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {
	
	public static String decodeParam(String s) {
		try {
			return URLDecoder.decode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	public static List<Integer> decodeIntList(String s) {
		
		List<Integer> integerList = new ArrayList<Integer>();
		String[] stringVector = s.split(",");
		
		for (int i = 0; i < stringVector.length; i++) {
			integerList.add(new Integer(stringVector[i]));
		}
		
		return integerList;
		
		
		//with Lambda:
		//return Arrays.asList(s.split(",")).stream().map(x -> Integer.parseInt((String) x)).collect(Collectors.toList());	
	}
}
