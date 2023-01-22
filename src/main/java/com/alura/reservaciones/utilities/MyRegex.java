package com.alura.reservaciones.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyRegex {
	public static String nameRegex = "([A-zÀ-ú]|\\s){3,20}$";
	public static String phoneNumberRegex = "^([0-9]){10}$";
	
	public static String moneyRegex = "[0-9]|(\\,)";
	
	public static boolean match(String input, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(input);
		
		return matcher.matches();
	}
	
}
