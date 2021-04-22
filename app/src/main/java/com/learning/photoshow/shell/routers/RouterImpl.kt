package com.learning.photoshow.shell.routers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.learning.photoshow.core.routers.Router


const val BUNDLE_KEY = "BUNDLE_KEY"

class RouterImpl(private val appCompactActivity: AppCompatActivity) : Router {
    override fun routeTo(destination: String, navigationArgs: String?, willBeFinished: Boolean) {
        RoutingTable.routers?.get(destination)?.apply {
            val intent = Intent(appCompactActivity, this).apply {
                navigationArgs?.let {
                    putExtra(BUNDLE_KEY, it)
                }
                if (willBeFinished) {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                }
            }
            appCompactActivity.startActivity(intent)
        }

    }

    override fun finish() {
        appCompactActivity.finish()
    }

}