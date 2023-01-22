package com.alura.reservaciones.utilities;

import java.text.NumberFormat;
import java.util.Locale;



public class MyUtilities {

	public static String formatMoney(Double amount, Locale locale) {
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		return currencyFormatter.format(amount);
	}

	public static double moneyToDouble(String formatedMoney) {
		formatedMoney = formatedMoney.replaceAll(MyRegex.moneyRegex, "");
		formatedMoney = formatedMoney.replaceAll(",", ".");
		return Double.valueOf(formatedMoney);
	}

	

}
