package id.go.kemlu.easytravel.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Erick Renata on 05/11/2016.
 */

public class ToastMessage {

    public static void toast(Context context, int message) {
        toast(context, context.getString(message));
    }

    public static void toast(Context context, String message) {
        if (!message.equals("No Data"))
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
