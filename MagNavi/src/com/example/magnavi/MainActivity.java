package com.example.magnavi;
 

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity
{
  Button btnonenterButton,btnonexitButton;
  byte []ins1={(byte)0xf1,(byte)0x01,(byte)0x01};
  byte []ins2={(byte)0xf1,(byte)0x01,(byte)0x01};
  byte []ins3={(byte)0xf1,(byte)0x01,(byte)0x01};
  byte []ins4={(byte)0xf1,(byte)0x01,(byte)0x01};
  byte []ins5={(byte)0xf1,(byte)0x01,(byte)0x01};
  byte []test;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnonenterButton=(Button)findViewById(R.id.btn_enter);
		btnonexitButton=(Button)findViewById(R.id.btn_exit);
		test=new byte[1];
		test[0]=(byte)0xf1;
		ins1(ins1,3);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onEnter(View v)
	{
		
		Intent intent_setting2=new Intent(MainActivity.this, DatatransActivity.class);
	    startActivityForResult(intent_setting2, 1);   
	}
	
	public void onExit(View v)
	{
		
		System.exit(0);
	}

	
	public void ins1(byte data[], int len)
	{
		 
		 
		
	}
}
