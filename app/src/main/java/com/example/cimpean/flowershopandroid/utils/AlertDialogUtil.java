package com.example.cimpean.flowershopandroid.utils;

import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Cimpean on 4/23/2018.
 */
public class AlertDialogUtil {

    public static void showAlertDialogText(String title, String message,Context context) {
        android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(android.app.AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
