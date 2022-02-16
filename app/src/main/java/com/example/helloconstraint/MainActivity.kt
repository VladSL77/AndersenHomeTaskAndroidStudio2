package com.example.helloconstraint

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val LOG_TAG_MAIN = "MainActivity"
const val LOG_TAG_SECOND = "SecondActivity"
const val KEY_MESSAGE = "Message"
const val KEY_REPLY = "Reply"
const val KEY_COUNT = "COUNT"
const val KEY_SAVE_COUNT = "save_count"
const val KEY_REPLY_VISIBLE = "reply_visible"
const val KEY_REPLY_TEXT = "reply_text"

class MainActivity : AppCompatActivity() {

    private var mCount = 0
    private lateinit var mShowCount: TextView
    private lateinit var mZeroButton: Button
    private lateinit var mCountButton: Button
    private lateinit var mMessageEditText: EditText
    private lateinit var mReplyTextView: TextView
    private lateinit var mHeaderReply: TextView

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (mReplyTextView.visibility == View.VISIBLE) {
            outState.putBoolean(KEY_REPLY_VISIBLE, true)
            outState.putString(KEY_REPLY_TEXT, mReplyTextView.text.toString())
        }
        outState.putInt(KEY_SAVE_COUNT, mCount)
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG_MAIN, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG_MAIN, "onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG_MAIN, "onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG_MAIN, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG_MAIN, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG_MAIN, "onDestroy")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val uri = intent.data
        if (uri != null) {
            val uriString = "URI: $uri"
            val textView: TextView = findViewById(R.id.text_uri_message)
            textView.text = uriString
        }

        mShowCount = findViewById(R.id.show_count)
        mZeroButton = findViewById(R.id.button_zero)
        mCountButton = findViewById(R.id.button_count)
        mMessageEditText = findViewById(R.id.editText_main)
        mReplyTextView = findViewById(R.id.text_message_reply)
        mHeaderReply = findViewById(R.id.text_header_reply)

        Log.d(LOG_TAG_MAIN, "-----------")
        Log.d(LOG_TAG_MAIN, "onCreate")

        if (intent.hasExtra(KEY_REPLY)) {
            mHeaderReply.visibility = View.VISIBLE
            mReplyTextView.visibility = View.VISIBLE
            mReplyTextView.text = intent.getStringExtra(KEY_REPLY).toString()
        }

        if (savedInstanceState != null) {
            val isVisible = savedInstanceState.getBoolean(KEY_REPLY_VISIBLE)
            if (isVisible) {
                mHeaderReply.visibility = View.VISIBLE
                mReplyTextView.text = savedInstanceState.getString(KEY_REPLY_TEXT)
                mReplyTextView.visibility = View.VISIBLE
            }
            mCount = savedInstanceState.getInt(KEY_SAVE_COUNT)
            mShowCount.text = mCount.toString()
        }
    }

    fun openHello(view: android.view.View) {
        val intentHello = Intent(this, HelloActivity::class.java)
        intentHello.putExtra(KEY_COUNT, mCount)
        startActivity(intentHello)
    }

    fun countUp(view: android.view.View) {
        mCount++
        mShowCount.text = mCount.toString()
        if (mCount % 2 == 0) {
            view.setBackgroundResource(R.color.teal_200)
        } else view.setBackgroundResource(R.color.teal_700)
        mZeroButton.setBackgroundResource(R.color.purple_500)
    }

    fun makeZero(view: android.view.View) {
        mCount = 0
        mShowCount.text = mCount.toString()
        mZeroButton.setBackgroundResource(R.color.color_gray)
        mCountButton.setBackgroundResource(R.color.purple_500)
    }

    fun launchSecondActivity(view: android.view.View) {
        Log.d(LOG_TAG_MAIN, "Button clicked!")
        val intentSecond = Intent(this, SecondActivity::class.java)
        intentSecond.putExtra(KEY_MESSAGE, mMessageEditText.text.toString())
        startActivity(intentSecond)
    }

    fun launchImplicitIntentsActivity(view: android.view.View) {
        val intentII = Intent(this, ImplicitIntents::class.java)
        startActivity(intentII)
    }
}