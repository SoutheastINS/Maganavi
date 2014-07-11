package com.magnavi.util;

public class mag_protocol
{
   byte[]ins1={(byte)0xf1,(byte)0x01,(byte)0xf1,(byte)0xf1,(byte)0xf1,(byte)0xf1,(byte)0xf1,(byte)0xf1};
	
	public void mag_protocol()
	{
		
	}
	
	public byte[] get_mag_power_status(int low_address, int high_address)
	{
		//·ÖÅäµØÖ·
		ins1[3]=(byte) (low_address&0x00ff);
		ins1[2]=(byte)((low_address>>8)&0x00ff);
		
		ins1[5]=(byte) (high_address&0x00ff);
		ins1[4]=(byte)((high_address>>8)&0x00ff);
		
		return ins1;
	}
}
