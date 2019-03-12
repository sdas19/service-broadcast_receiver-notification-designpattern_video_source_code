package ittoolstraining.com.sampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Main2Activity : AppCompatActivity() {

    val TAG = Main2Activity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val customObject = intent.getParcelableExtra<CustomObject>("key") as CustomObject

        customObject?.let {
            Log.e(TAG,customObject.name)
        }
    }
}