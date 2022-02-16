package com.example.helloconstraint

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat

const val KEY_IS_ADDED = "isAdded"

class ImplicitIntents : AppCompatActivity() {

    private lateinit var mWebsiteEditText: EditText
    private lateinit var mLocationEditText: EditText
    private lateinit var mShareTextEditText: EditText
    private lateinit var arrayTextView: List<TextView>
    private lateinit var item1: TextView
    private lateinit var item2: TextView
    private lateinit var item3: TextView
    private lateinit var item4: TextView
    private lateinit var item5: TextView
    private var isAdded = false

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        for (i in 0..arrayTextView.lastIndex) {
            outState.putString("item$i", arrayTextView[i].text.toString())
        }
        outState.putBoolean(KEY_IS_ADDED, isAdded)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intents)
        mWebsiteEditText = findViewById(R.id.website_edittext)
        mLocationEditText = findViewById(R.id.location_edittext)
        mShareTextEditText = findViewById(R.id.share_edittext)
        item1 = findViewById(R.id.item1)
        item2 = findViewById(R.id.item2)
        item3 = findViewById(R.id.item3)
        item4 = findViewById(R.id.item4)
        item5 = findViewById(R.id.item5)
        arrayTextView = mutableListOf(item1, item2, item3, item4, item5)
        if (savedInstanceState != null) {
            for (i in 0..arrayTextView.lastIndex) {
                arrayTextView[i].text = savedInstanceState.getString("item$i")
            }
            isAdded = savedInstanceState.getBoolean(KEY_IS_ADDED)
        }
    }

    private fun updateList(string: String) {
        var isFull = true
        for (i in 0..arrayTextView.lastIndex) {
            if (arrayTextView[i].text == "") {
                arrayTextView[i].text = string
                isFull = false
                break
            }
        }
        if (isFull) {
            Toast.makeText(this, getString(R.string.list_is_full), Toast.LENGTH_SHORT).show()
        }
    }

    fun openWebsite(view: android.view.View) {
        val webpage = Uri.parse(mWebsiteEditText.text.toString())
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this!")
        }
    }

    fun openLocation(view: android.view.View) {
        val addressUri = Uri.parse("geo:0,0?q=${mLocationEditText.text}")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this!")
        }
    }

    fun shareText(view: android.view.View) {
        ShareCompat.IntentBuilder
            .from(this)
            .setType("text/plain")
            .setChooserTitle(getString(R.string.chooser_title))
            .setText(mShareTextEditText.text)
            .startChooser()
    }

    fun takePicture(view: android.view.View) {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this!")
        }
    }

    fun addItem(view: android.view.View) {
        val intent = Intent(this, ShoppingListActivity::class.java)
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    updateList(data.getStringExtra(KEY_CHOSEN_ITEM).toString())
                    isAdded = true
                }
            }
        }
    }
}