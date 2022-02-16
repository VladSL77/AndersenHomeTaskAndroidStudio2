package com.example.helloconstraint

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var mTextMessage: TextView
    private lateinit var mReplyEditText: EditText

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG_SECOND, "onStartSecond")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG_SECOND, "onResumeSecond")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG_SECOND, "onRestartSecond")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG_SECOND, "onPauseSecond")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG_SECOND, "onStopSecond")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG_SECOND, "onDestroySecond")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        mTextMessage = findViewById(R.id.text_message)
        mReplyEditText = findViewById(R.id.editText_Second)
        if (intent.hasExtra(KEY_MESSAGE)) {
            mTextMessage.text = intent.getStringExtra(KEY_MESSAGE).toString()
        }
    }

    fun returnReply(view: android.view.View) {
        val intentMain = Intent(this, MainActivity::class.java)
        intentMain.putExtra(KEY_REPLY, mReplyEditText.text.toString())
        Log.d(LOG_TAG_SECOND, "End SecondActivity")
        startActivity(intentMain)
    }
}