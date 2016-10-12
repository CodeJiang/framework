package com.jiang.framework.util;

public class CommonUtil {
	
	public static byte[] getDiscardByte(int length){
		byte[] datas = new byte[length];
		for(int i=0;i<datas.length;i++){
			datas[i] = (byte) (0xff|(i-1));
		}
		
		return datas;
	}
}
