package com.magnavi.util;

import java.util.Locale;

public class CRC16 {

	public static String getCRC(byte[] bytes, int count){
		String back="";
		int crc = 0xFFFF;          // initial value
	    int polynomial = 0x1021;   // 0001 0000 0010 0001  (0, 5, 12) 

	    for (byte b : bytes) {
	        for (int i = 0; i < count; i++) {
	            boolean bit = ((b   >> (7-i) & 1) == 1);
	            boolean c15 = ((crc >> 15    & 1) == 1);
	            crc <<= 1;
	            if (c15 ^ bit) crc ^= polynomial;
	         }
	    }

	    crc &= 0xffff;
	    back=Integer.toHexString(crc);

		return back;
	}
	
	   /** 
     * bytes字符串转换为Byte值 
     * @param src String Byte字符串，每个Byte之间没有分隔符(字符范围:0-9 A-F) 
     * @return byte[] 
     */  
    public static byte[] hexStr2Bytes(String src){  
        /*对输入值进行规范化整理*/  
        src = src.trim().replace(" ", "").toUpperCase(Locale.US);  
        //处理值初始化  
        int m=0,n=0;  
        int iLen=src.length()/2; //计算长度  
        byte[] ret = new byte[iLen]; //分配存储空间  
          
        for (int i = 0; i < iLen; i++){  
            m=i*2+1;  
            n=m+1;  
            ret[i] = (byte)(Integer.decode("0x"+ src.substring(i*2, m) + src.substring(m,n)) & 0xFF);  
        }  
        return ret;  
    }  
  
}
