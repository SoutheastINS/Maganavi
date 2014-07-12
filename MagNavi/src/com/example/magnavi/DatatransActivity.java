package com.example.magnavi;

import java.io.UnsupportedEncodingException;

import com.magnavi.util.mag_protocol;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DatatransActivity extends Activity
{
  TextView resultTextView;
  mag_protocol mag_protocol;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_datatrans_);
		resultTextView=(TextView)findViewById(R.id.result_text);
		mag_protocol=new mag_protocol();
		
	}

	
	public void onclickins1(View v) throws UnsupportedEncodingException
	{
		byte ins1[]=mag_protocol.get_mag_power_status(mag_protocol.ins1, 0, 1);
		
		
		
		 
			resultTextView.setText(ByteToString(ins1));
		 
	}
	
	
	public static String ByteToString(byte[] bytes)

	{

	String returnString="";

	for (int i = 0; i < bytes.length; i++)
	{
		returnString+= Integer.toHexString(bytes[i]&0xff)+" ";
	}
	
		return returnString ;

	}

}
