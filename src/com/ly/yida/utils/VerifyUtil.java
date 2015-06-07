package com.ly.yida.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyUtil {
	public static boolean isEmail(String strEmail) {
		String strPattern = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		Pattern p = Pattern.compile(strPattern);
		Matcher m = p.matcher(strEmail);
		if (m.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isCellphone(String str) {
		Pattern pattern = Pattern.compile("1[0-9]{10}");
		Matcher matcher = pattern.matcher(str);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isPassword(String str){
		/*Pattern pattern = Pattern.compile("^[a-z0-9A-Z]{6,15}$");
		Matcher matcher = pattern.matcher(str);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}*/
		Pattern p = Pattern.compile("[a-zA-Z]+");
     	//Pattern q = Pattern.compile("[a-z]+");
     	Pattern r = Pattern.compile("[0-9]+");
     	//Pattern s = Pattern.compile("\\p{Punct}+");
     	Matcher m1 = p.matcher(str);  //判断是否含有大写字符
     	//Matcher m2= q.matcher(str); //判断是否含有小写字符
     	Matcher m3 = r.matcher(str);//判断是否含有数字
     	//Matcher m4 = s.matcher(str);//判断是否含有特殊字符
     	return !m1.matches()&&!m3.matches();
	}
}
