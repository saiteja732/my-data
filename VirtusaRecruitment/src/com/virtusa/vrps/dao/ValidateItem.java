package com.virtusa.vrps.dao;

import java.text.DecimalFormat;

public class ValidateItem {

	public float rateCalculation(int sum,int count) {
		int total;
		DecimalFormat decimalFormat = new DecimalFormat();
		float rate;
		if(sum==0 && count==0) {
			return 0;
		} else {
			total=count*5;
			rate=(float)sum/total;
			decimalFormat.setMaximumFractionDigits(1);
			rate = Float.valueOf(decimalFormat.format(rate));
			return rate;
		}
	}
	
	public String stringValidate(String str) {

		if(str==null) {
			return "";
		}
		return str;
	}
	
	
	
}
