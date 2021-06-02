package martialcoder.surajsahani.turbocaretestassignment.SharedPrefrences

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.net.ConnectivityManager
import martialcoder.surajsahani.turbocaretestassignment.R

class CommonUtils {
    companion object {
        private var progressDialog: ProgressDialog? = null

        fun isNetworkConnected(context: Context): Boolean {
            val cm =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return cm.activeNetworkInfo != null
        }


        fun showProgress(activity: Activity?, message: String?) {
            progressDialog = ProgressDialog(activity, R.style.DialogStyle)
            progressDialog!!.setMessage(message)
            progressDialog!!.setCanceledOnTouchOutside(false)
            progressDialog!!.show()
        }

        fun dismissProgress() {
            if (progressDialog != null && progressDialog!!.isShowing) {
                progressDialog!!.dismiss()
            }
        }

    }
}