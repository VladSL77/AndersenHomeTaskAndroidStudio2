package com.example.helloconstraint

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThreeTextActivity : AppCompatActivity() {

    private var idButton = 0
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three_text)
        textView = findViewById(R.id.textView)
        if (intent.hasExtra(KEY_BUTTON)) {
            idButton = intent.getIntExtra(KEY_BUTTON, 0)
        }
        when (idButton) {
            1 -> textView.text = getString(R.string.text_one)
            2 -> textView.text = getString(R.string.text_two)
            3 -> textView.text = getString(R.string.text_three)
            else -> textView.text = getString(R.string.something_wrong)
        }
    }
}