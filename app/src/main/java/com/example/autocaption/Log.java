package com.example.autocaption;

public final class Log {

	private static Log mInstance = null;
	private final static String TAG = "LooooooG";

	public static synchronized Log getInstance(){
		if (mInstance == null) {
			mInstance = new Log();
		}

		return mInstance;
	}

	public static void v() {
		android.util.Log.v(TAG, getCodeAddress());
	}
	
	public static void v(String msg) {
		v(TAG, msg);
	}
	
	private static String getCodeAddress() {
		StackTraceElement[] sts = Thread.currentThread().getStackTrace();

		if (sts == null) {
			return null;
		}

		for (StackTraceElement st : sts) {
			if (st.isNativeMethod()) {
				continue;
			}

			if (st.getClassName().equals(Thread.class.getName())) {
				continue;
			}

			if (st.getClassName().equals(getInstance().getClass().getName())) {
				continue;
			}

			return "[ " + st.getFileName() + ":" + st.getLineNumber() + " ]";
		}

		return null;
	}

	public static int i(String tag, String msg) {
		return android.util.Log.i(tag, getCodeAddress() + " - " + msg);

	}

	public static int e(String tag, String msg) {
		return android.util.Log.e(tag, getCodeAddress() + " - " + msg);
	}

	public static int w(String tag, Throwable exception) {
		String msg = exception.getMessage();

		if (null == msg) {
			exception.printStackTrace();
			msg = "no exception msg!";
		}
		return w(tag, getCodeAddress() + " - " + msg);
	}

	public static int d(String tag, String msg) {
		return android.util.Log.d(tag, getCodeAddress() + " - " + msg);
	}

	public static int v(String tag, String msg) {
		return android.util.Log.v(tag, getCodeAddress() + " - " + msg);
	}

	public static int w(String tag, String msg) {
		return android.util.Log.w(tag, getCodeAddress() + " - " + msg);
	}
}
