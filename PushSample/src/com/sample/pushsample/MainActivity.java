package com.sample.pushsample;

import static com.sample.pushsample.CommonUtilities.SENDER_ID;
import com.google.android.gcm.GCMRegistrar;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView.BufferType;

public class MainActivity extends Activity {
	
	String regId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		/* Push Notification Service */
		try{
			GCMRegistrar.checkDevice(this);
			GCMRegistrar.checkManifest(this);
			regId = GCMRegistrar.getRegistrationId(this);
			if (regId.equals("")) {
			  GCMRegistrar.register(this, SENDER_ID);
			  regId = GCMRegistrar.getRegistrationId(this);
			} else {
			  Log.i("TAG", "Already registered");
			}
		}
		catch(Exception e ){
			Log.d("GCM_LOG", "Exception :" + e);
		}  
		
		LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(linearLayout);
		
		EditText edit = new EditText(this);
        
        edit.setText(regId, BufferType.NORMAL);
        linearLayout.addView(edit, 
                new LinearLayout.LayoutParams(1000, 500));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}	
}
