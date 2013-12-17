/**
 * 
 */
package com.smsalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * @author Àðò¸ì
 * 
 */
public class Receiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		Bundle bundle = intent.getExtras();
		SmsMessage[] msgs = null;
		String msg_from = null;
		
		if (bundle != null) {
			try {
				Object[] pdus = (Object[]) bundle.get("pdus");
				msgs = new SmsMessage[pdus.length];
				
				boolean isNumber000019 = false;
				
				for (int i = 0; i < msgs.length && !isNumber000019; i++) {
					msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
					msg_from = msgs[i].getOriginatingAddress();

					String msgBody = msgs[i].getMessageBody();
					
					if (msg_from.equals(MainActivity.TELEPHONE_NUMBER)) {
						isNumber000019 = true;
					}
				}
				
				if (isNumber000019) {
					MainActivity.startPlay();
				}
			} catch (Exception e) {

				Toast.makeText(context, "exception on sms catch",
						Toast.LENGTH_LONG).show();

			}
		}
	}

}
