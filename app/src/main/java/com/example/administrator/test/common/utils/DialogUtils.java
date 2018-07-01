package com.example.administrator.test.common.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.test.R;

/**
 * Created by Administrator on 2016/12/23.
 */
public class DialogUtils {
    /**
     * 加载中遮罩层
     *
     * @param context
     * @return
     */
    public static Dialog showLoading(Context context, String messge) {
        Dialog dialog = null;
        View mView = LayoutInflater.from(context).inflate(
                R.layout.base_loading, null);
        mView.setBackgroundResource(R.drawable.base_loading_bg);
        mView.setVisibility(View.VISIBLE);
        mView.setPadding(30, 30, 30, 30);
        TextView tv = (TextView) mView.findViewById(R.id.base_loading_msg);
        tv.setTextColor(ContextCompat.getColor(context,R.color.color_ff));
        if (!TextUtils.isEmpty(messge)) {
            tv.setText(messge);
        }
        dialog = new Dialog(context, R.style.CommonLoadingShadeDialog);
        dialog.setContentView(mView);
        dialog.show();
        return dialog;
    }

    /**
     * 确认对话框
     *
     * @param context
     * @param message
     * @param listener
     */
    public static void confirm(final Context context, String message,
                               DialogInterface.OnClickListener listener) {
        AlertDialog.Builder bui = new AlertDialog.Builder(context);
        bui.setTitle("温馨提示");
        bui.setMessage(message);
        bui.setPositiveButton("是", listener);
        bui.setNegativeButton("否", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                LogUtils.e("否---","否");
                dialog.cancel();
            }
        });
        AlertDialog mExitDialog = bui.create();
        mExitDialog.show();
    }
}
