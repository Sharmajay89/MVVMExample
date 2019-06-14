package com.service.testapplication

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.LinearLayout
import android.widget.TextView

class Utils {

    companion object {
        fun <T> showCustomConfirmationDialog(context: Context, title:String, actionBtn:String, info:String, data:T) {
            if (context == null) return
            var mAlertDialog = Dialog(context)
            mAlertDialog.setCancelable(false)
            mAlertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            mAlertDialog.getWindow().setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            mAlertDialog.setContentView(R.layout.confirmation_layout)
            val mtitle = mAlertDialog.findViewById(R.id.title) as TextView
            val msg1 = mAlertDialog.findViewById(R.id.msg1) as TextView

            val mCancelOkBtnView = mAlertDialog!!.findViewById(R.id.mCancelOkBtnView) as LinearLayout
            val mOkBtnView = mAlertDialog!!.findViewById(R.id.mOkBtnView) as LinearLayout
            val mOkBtn = mAlertDialog!!.findViewById(R.id.mOkBtn) as TextView
            val mCancelBtn = mAlertDialog!!.findViewById(R.id.mCancelBtn) as TextView
            val mUploadAgainBtn = mAlertDialog!!.findViewById(R.id.mUploadAgainBtn) as TextView
            mtitle.text = title
            msg1.text = info

            mUploadAgainBtn.text = actionBtn
            mCancelBtn.setOnClickListener { view ->
                if (mAlertDialog != null) mAlertDialog.dismiss()
            }
            mOkBtn.setOnClickListener { view ->
                if (mAlertDialog != null) mAlertDialog.dismiss()
            }
            mUploadAgainBtn.setOnClickListener { view ->
                if (mAlertDialog != null) mAlertDialog.dismiss()
            }

            if (mAlertDialog != null) mAlertDialog.show()
        }

     }
    }
