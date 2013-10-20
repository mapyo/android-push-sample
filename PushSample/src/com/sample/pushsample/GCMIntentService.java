package com.sample.pushsample;

import static com.sample.pushsample.CommonUtilities.SENDER_ID;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.gcm.GCMBaseIntentService;

public class GCMIntentService extends GCMBaseIntentService {
	
    public GCMIntentService() {
        super(SENDER_ID);
    }

    @Override
    public void onRegistered(Context context, String registrationId) {
        Log.w("registration id:", registrationId);
        sendMessage("id:" + registrationId);
    }
 
    @Override
    protected void onUnregistered(Context context, String registrationId) {
        sendMessage("C2DM Unregistered");
    }
 
    @Override
    public void onError(Context context, String errorId) {
        sendMessage("err:" + errorId);
    }
 
    @Override
    protected void onMessage(Context context, Intent intent) {
        String str = intent.getStringExtra("message");
        Log.w("message:", str);
        sendMessage(str);
    }

    //本体側に通知する設定
    private void sendMessage(String str) {
    	Notification n = new Notification(); // Notificationの生成
    	n.icon = R.drawable.ic_launcher; // アイコンの設定
    	n.tickerText = str; // メッセージの設定
    	
    	// PendingIntentの生成
    	Intent i = new Intent(getApplicationContext(), MainActivity.class);
    	PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);
    	 
    	// 詳細情報の設定とPendingIntentの設定
    	n.setLatestEventInfo(getApplicationContext(), "PUSH test!", str, pi);
    	
    	NotificationManager nm =
    			   (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
    	nm.notify(1, n); // 生成したNotificationを通知する
    }
}