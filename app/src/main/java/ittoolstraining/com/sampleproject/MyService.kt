package ittoolstraining.com.sampleproject

import android.app.IntentService
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    val TAG = MyService::class.java.simpleName

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG,"onCreate")

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val incomingString = intent?.getParcelableExtra<CustomObject>("key")
        Log.i(TAG,"onStartCommand string -->$incomingString")
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"onDestroy")

    }
}

class MyIntentService : IntentService("MyIntentService")
{
    val TAG = MyIntentService::class.java.simpleName

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG,"onCreate")

    }

    override fun onHandleIntent(intent: Intent?) {
        val incomingString = intent?.getParcelableExtra<CustomObject>("key")
        Log.i(TAG,"onHandleIntent$incomingString"+"thread -->${Thread.currentThread().name}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"onDestroy")

    }

}