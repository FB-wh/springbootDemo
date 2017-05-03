package org.fb.utils;

import java.util.Random;

public class RandomTool {
	/**
	 * 产生指定位数的字符串
	 * 
	 * @param length
	 * @return
	 */
	public static String genStrToken(int length) {
		String base = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 产生指定位数的数字字符串
	 * 
	 * @param length
	 * @return
	 */
	public static String genNumToken(int length) {
		String base = "1234567890";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
}
