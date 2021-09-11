package com.dog.cursospring.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {
	
	public static List<Integer> decodeIntList(String s){
		List<Integer> ids = new ArrayList<>();
		String [] vet = s.split(",");
		for(int i=0; i<vet.length; i++) {
			ids.add(Integer.parseInt(vet[i]));
		}
		return ids;
	}
	
	public static String decodeParam(String s) {
		try {
			return URLDecoder.decode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
