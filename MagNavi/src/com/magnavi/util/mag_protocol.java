package com.magnavi.util;

import java.io.UnsupportedEncodingException;

import android.util.Log;

public class mag_protocol
{
	/**
	 * 6 Instructions-click button to send
	 * power status send to pc
	 * 2header+2addr+2satus+2CRC
	 * 0x01
	 */
    public byte[]ins1={(byte)0xf1,(byte)0x01,(byte)0xf1,(byte)0xf1,(byte)0xf1,(byte)0xf1,(byte)0xf1,(byte)0xf1};
    public byte[]ins2={(byte)0xf1,(byte)0x01,(byte)0xf1,(byte)0xf1,(byte)0xf1,(byte)0xf1,(byte)0xf1,(byte)0xf1};
    public byte[]ins3={(byte)0xf1,(byte)0x01,(byte)0xf1,(byte)0xf1,(byte)0xf1,(byte)0xf1,(byte)0xf1,(byte)0xf1};
    public byte[]ins4={(byte)0xf1,(byte)0x01,(byte)0xf1,(byte)0xf1,(byte)0xf1,(byte)0xf1,(byte)0xf1,(byte)0xf1};
    public byte[]ins5={(byte)0xf1,(byte)0x01,(byte)0xf1,(byte)0xf1,(byte)0xf1,(byte)0xf1,(byte)0xf1,(byte)0xf1};	
    public byte[]ins6={(byte)0xf1,(byte)0x01,(byte)0xf1,(byte)0xf1,(byte)0xf1,(byte)0xf1,(byte)0xf1,(byte)0xf1};
    
    /**
     * 何时驱动发送暂时没有思考
     * power voltage and current feedback
     * 3header+16vol+16curr+2CRC
     * 0x03
     */
    byte[] vi = new byte[32];
    
    /**
     * pc send data 
     * 2header+unknown+7-22 8路电流控制量+2CRC
     * should return string to show
     * 0x10
     */
    byte[] rec_buffer;

	
	public mag_protocol()
	{
	}
	
	/**
	 * @param bytes
	 * @param addr
	 * @param status
	 * @return ins1-6
	 * @throws UnsupportedEncodingException 
	 */
	public byte[] get_mag_power_status(byte [] bytes, int addr, int status) throws UnsupportedEncodingException
	{
		//分配地址
		bytes[3]=(byte) (addr&0x00ff);
		bytes[2]=(byte)((addr>>8)&0x00ff);
		
		bytes[5]=(byte) (status&0x00ff);
		bytes[4]=(byte)((status>>8)&0x00ff);
		
		//校验CRC的samplecode
		//getCRC
		//hexStr2Byte
		//after should rewrite in one function
		String CRC = CRC16.getCRC(bytes, 6);
		Log.d("sCRC", "the string of crc is"+ CRC);
		byte[] str2byte = CRC16.hexStr2Bytes(CRC);
		bytes[7]= (byte)(str2byte[1]&0x00ff);
		bytes[6]= (byte)(str2byte[0]&0x00ff);
		
		return bytes;
	}
	/**
	 * @param num 1-8
	 * @param vol
	 * @param cur
	 * @return vi
	 */
	public byte[] get_mag_power_VI(int num, int vol, int cur){
		
		vi[1+num*4]=(byte) (cur&0x00ff);
		vi[num*4]  =(byte) ((cur>>8)&0x00ff);
		
		vi[3+num*4]=(byte) (vol&0x00ff);
		vi[2+num*4]  =(byte) ((vol>>8)&0x00ff);
		return vi;
	}
	
	/**
	 * @param bytes
	 * @return string
	 */
	public String set_mag_power_bypc(byte[] bytes){
		//find 0x10 , check crc
		String show_power_current = "";
		
		return show_power_current;
	}
	
}
