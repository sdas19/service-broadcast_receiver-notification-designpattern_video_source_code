package ittoolstraining.com.sampleproject

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class ExampleBroadCastReceiver : BroadcastReceiver() {

    val TAG = ExampleBroadCastReceiver::class.java.simpleName

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i(TAG,"static broadcast received")
    }
}