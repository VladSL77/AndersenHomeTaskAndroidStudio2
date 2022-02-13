package com.example.helloconstraint

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var mCount = 0
    private lateinit var mShowCount: TextView
    private lateinit var mZero: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Main Activity", "Hello World")
        mShowCount = findViewById(R.id.show_count)
        mZero = findViewById(R.id.button_zero)
    }

    fun showToast(view: android.view.View) {
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
    }

    fun countUp(view: android.view.View) {
        mCount++
        mShowCount.text = mCount.toString()
        if (mCount % 2 == 0) {
            view.setBackgroundColor(Color.GREEN)
        } else view.setBackgroundColor(Color.CYAN)
        mZero.setBackgroundColor(Color.MAGENTA)
    }

    @SuppressLint("ResourceAsColor")
    fun makeZero(view: android.view.View) {
        mCount = 0
        mShowCount.text = mCount.toString()
        mZero.setBackgroundColor(R.color.color_gray)
    }
}