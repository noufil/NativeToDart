package com.active.active

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

const val MY_CHANNEL = "My_Channel"

class MainActivity : FlutterActivity() {

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(
            flutterEngine.dartExecutor.binaryMessenger,
            MY_CHANNEL
        ).setMethodCallHandler { call, result ->
            if (call.method == "result") {
                setResult(call.arguments as Int)
            }
            result.success(0)
        }
    }
}
