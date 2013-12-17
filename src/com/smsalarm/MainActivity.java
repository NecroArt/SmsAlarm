package com.smsalarm;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MainActivity extends Activity {

	public static final String TELEPHONE_NUMBER = "000019";
	private static Ringtone r = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Uri alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
		if (alert == null) {
			// alert is null, using backup
			alert = RingtoneManager
					.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
			if (alert == null) { // I can't see this ever being null (as always
									// have a default notification) but just
									// incase
				// alert backup is null, using 2nd backup
				alert = RingtoneManager
						.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
			}
		}
		r = RingtoneManager
				.getRingtone(getApplicationContext(), alert);
		setContentView(R.layout.activity_main);
	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		Notification notification=new Notification(android.R.drawable.ic_btn_speak_now,"hi",100);
		notification.sound = Uri.parse("android.resource://" + getPackageName() + "/" R.raw.notifysnd);
		notification.defaults = Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE;
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}*/

	public static void startPlay(View view) {
		
		r.play();
	}
	
	public static void startPlay() {
		
		r.play();
	}
	
	public static void stopPlay(View view) {
		
		r.stop();
	}
	
	public static void stopPlay() {
		
		r.stop();
	}
	
	public static void registerService(View view) {
		надо это доделать
		Service s = new Service() {
			
			@Override
			public IBinder onBind(Intent intent) {
				// TODO Auto-generated method stub
				return null;
			}
		}; 
		s.startForeground(1, null);
	}

}
