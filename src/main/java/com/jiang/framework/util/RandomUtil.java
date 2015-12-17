package com.jiang.framework.util;

import java.util.Random;

public class RandomUtil {
	public static int getRandomNum(int min, int max){
		Random random = new Random();
		
		return random.nextInt(max-min)+min-1;
	}
}
