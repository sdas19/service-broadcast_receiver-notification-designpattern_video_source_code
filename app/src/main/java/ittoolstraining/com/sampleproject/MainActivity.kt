package ittoolstraining.com.sampleproject

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.View
import androidx.core.app.NotificationCompat
import ittoolstraining.com.sampleproject.CustomApplication.Companion.CHANNEL_1_ID
import androidx.core.app.NotificationManagerCompat
import ittoolstraining.com.sampleproject.CustomApplication.Companion.CHANNEL_2_ID


class MainActivity : AppCompatActivity() {

    val dynamicBroadcastReceiver = DynamicBroadCastReceiver()
    lateinit var notificationManager: NotificationManagerCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        notificationManager = NotificationManagerCompat.from(this)


    }

    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(dynamicBroadcastReceiver,intentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(dynamicBroadcastReceiver)
    }

    fun sendOnChannel1(view : View)
    {
        val notification = NotificationCompat.Builder(this, CHANNEL_1_ID)
            .setContentTitle("Channel 1")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentText("This is notification on channel 1")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .build()

        notificationManager.notify(1, notification)
    }

    fun sendOnChannel2(view : View)
    {
        val notification = NotificationCompat.Builder(this, CHANNEL_2_ID)
            .setContentTitle("Channel 2")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentText("This is notification on channel 2")
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .build()

        notificationManager.notify(2, notification)
    }

    fun startService(view : View)
    {
        val intent = Intent(this,MyIntentService::class.java)
        val customObject = CustomObject(1,"Soumyajit")
        intent.putExtra("key",customObject)
        startService(intent)
    }

    fun stopService(view : View)
    {
        val intent = Intent(this,MyService::class.java)
        stopService(intent)
    }

}


data class CustomObject(val id:Int,val name:String) : Parcelable
{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CustomObject> {
        override fun createFromParcel(parcel: Parcel): CustomObject {
            return CustomObject(parcel)
        }

        override fun newArray(size: Int): Array<CustomObject?> {
            return arrayOfNulls(size)
        }
    }

}

class DynamicBroadCastReceiver : BroadcastReceiver()
{
    val TAG = DynamicBroadCastReceiver::class.java.simpleName

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i(TAG,"dynamic recieved")
    }

}


