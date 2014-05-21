package cn.com.crowdsourcedtesting.controller;

import java.util.Random;

public class RandomCode {
	
	private Random random;
	
	private StringBuffer randomcode;
	
	private char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			   'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			   'X', 'Y', 'Z' ,'1','2','3','4','5','6','7','8','9','0'};
	
	public RandomCode() {
		// TODO Auto-generated constructor stub
		this.random = new Random();
		this.randomcode = new StringBuffer();
	}
	
	public String getRandomCode(int number)
	{
		for (int i = 0; i < number; i++) {
			String str = String.valueOf(codeSequence[random.nextInt(36)]);
			randomcode.append(str.toLowerCase());
		}
		return randomcode.toString();
	}
}
