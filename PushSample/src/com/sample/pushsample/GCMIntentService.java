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

    //�{�̑��ɒʒm����ݒ�
    private void sendMessage(String str) {
    	Notification n = new Notification(); // Notification�̐���
    	n.icon = R.drawable.ic_launcher; // �A�C�R���̐ݒ�
    	n.tickerText = str; // ���b�Z�[�W�̐ݒ�
    	
    	// PendingIntent�̐���
    	Intent i = new Intent(getApplicationContext(), MainActivity.class);
    	PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);
    	 
    	// �ڍ׏��̐ݒ��PendingIntent�̐ݒ�
    	n.setLatestEventInfo(getApplicationContext(), "PUSH test!", str, pi);
    	
    	NotificationManager nm =
    			   (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
    	nm.notify(1, n); // ��������Notification��ʒm����
    }
}