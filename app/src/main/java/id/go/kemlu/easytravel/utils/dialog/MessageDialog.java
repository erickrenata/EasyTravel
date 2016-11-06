package id.go.kemlu.easytravel.utils.dialog;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;

import id.go.kemlu.easytravel.R;

/**
 * Created by Erick Renata on 05/11/2016.
 */

public class MessageDialog {

    public static void showMessage(Context context, int message) {
        showMessage(context, context.getString(message));
    }

    public static void showMessage(Context context, String message) {
        new MaterialDialog.Builder(context)
                .content(message)
                .positiveText(R.string.ok)
                .onPositive((dialog, which) -> dialog.dismiss())
                .show();
    }
}
