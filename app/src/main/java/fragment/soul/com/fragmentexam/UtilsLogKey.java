package fragment.soul.com.fragmentexam;

import android.content.Context;

/**
 * Created by sould on 2016-03-16.
 */
public class UtilsLogKey {

	public static String getTAG(Context context){
		return context.getClass().getSimpleName();
	}
}
