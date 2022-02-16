package com.example.helloconstraint

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val KEY_BUTTON = "Button id"

class HelloActivity : AppCompatActivity() {

    private lateinit var mCountTextView: TextView
    private var idButton = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)
        mCountTextView = findViewById(R.id.textViewCount)
        if (intent.hasExtra(KEY_COUNT)) {
            mCountTextView.text = intent.getIntExtra(KEY_COUNT, 0).toString()
        }
    }

    fun clickOne(view: android.view.View) {
        idButton = 1
        launchIntent()
    }

    fun clickTwo(view: android.view.View) {
        idButton = 2
        launchIntent()
    }

    fun clickThree(view: android.view.View) {
        idButton = 3
        launchIntent()
    }

    fun launchIntent() {
        val intent = Intent(this, ThreeTextActivity::class.java)
        intent.putExtra(KEY_BUTTON, idButton)
        startActivity(intent)
    }
}

