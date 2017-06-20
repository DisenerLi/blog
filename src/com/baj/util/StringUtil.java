package com.baj.util;

/**
 * Created by liqiang on 2017/6/20.
 */
public class StringUtil {

	public static boolean isEmpty(String str){
		int strLen;
		 if(null == str || (strLen=str.length())==0){
		 	return true;
		 }
		for(int i = 0;i<strLen;i++){
			if(!Character.isWhitespace(str.charAt(i))){
				return false;
			}
		}
		return true;
	}

	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}
}
