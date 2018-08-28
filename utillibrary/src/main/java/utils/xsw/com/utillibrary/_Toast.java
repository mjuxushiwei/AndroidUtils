package utils.xsw.com.utillibrary;

import android.content.Context;


public class _Toast {
	
	public static void showToast(Context mContext, int resId){
		Toast.makeText(mContext, mContext.getResources().getString(resId), Toast.LENGTH_SHORT).show();
	}
	
	public static void showToast(Context mContext, String str){
		Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show();
	}

}
