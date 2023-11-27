package com.active.active

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import io.flutter.embedding.android.FlutterActivity

class MyActivity : AppCompatActivity() {

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            findViewById<TextView>(R.id.result).text = "${result.resultCode}"
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)
        findViewById<Button>(R.id.button).setOnClickListener {
            startForResult.launch(
                FlutterActivity.NewEngineIntentBuilder(
                    MainActivity::class.java
                ).build(this)
            )
        }
    }
}