package com.siwei.frame.common.utils.util;

import java.math.BigDecimal;

/**
 * @Description 数字工具类
 * @author siwei
 * @date 2018年8月6日
 */
public class NumberUtil {

	/**
	 * @param number
	 * @return
	 */
	public static int stringToInt(String number) {
		double doubleNumber = Double.parseDouble(number);
		int intNumber = Integer.parseInt(new java.text.DecimalFormat("0").format(doubleNumber));
		return intNumber;
	}
	
	/**
	 * double值相加
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static double sum(double d1,double d2){ 
        BigDecimal bd1 = new BigDecimal(Double.toString(d1)); 
        BigDecimal bd2 = new BigDecimal(Double.toString(d2)); 
        return bd1.add(bd2).doubleValue(); 
    }
}
