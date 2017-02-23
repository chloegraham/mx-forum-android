package com.example.joshua.mx_forum_app;

import android.content.Context;
import android.widget.Toast;

public class ToastSingleton {
	private static Toast instance;
	
	private ToastSingleton() {}
	
	public synchronized static Toast getInstance(Context context) {
		if (instance == null) {
			instance = Toast.makeText(context, "", Toast.LENGTH_SHORT);	
		}
		return instance;
	}
}
