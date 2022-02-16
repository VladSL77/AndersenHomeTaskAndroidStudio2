package com.example.helloconstraint

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

const val KEY_CHOSEN_ITEM = "Chosen Item"

class ShoppingListActivity : AppCompatActivity() {

    private var chosenItem = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_list)
    }

    private fun launchActivity() {
        val intent = Intent(this, ImplicitIntents::class.java)
        intent.putExtra(KEY_CHOSEN_ITEM, chosenItem)
        setResult(RESULT_OK, intent)
        finish()
    }

    fun addApple(view: android.view.View) {
        chosenItem = getString(R.string.apple)
        launchActivity()
    }

    fun addBanana(view: android.view.View) {
        chosenItem = getString(R.string.banana)
        launchActivity()
    }

    fun addKiwi(view: android.view.View) {
        chosenItem = getString(R.string.kiwi)
        launchActivity()
    }

    fun addMilk(view: android.view.View) {
        chosenItem = getString(R.string.milk)
        launchActivity()
    }

    fun addJuice(view: android.view.View) {
        chosenItem = getString(R.string.juice)
        launchActivity()
    }

    fun addGrappa(view: android.view.View) {
        chosenItem = getString(R.string.grappa)
        launchActivity()
    }

    fun addSausage(view: android.view.View) {
        chosenItem = getString(R.string.sausage)
        launchActivity()
    }

    fun addFish(view: android.view.View) {
        chosenItem = getString(R.string.fish)
        launchActivity()
    }

    fun addCheese(view: View) {
        chosenItem = getString(R.string.cheese)
        launchActivity()
    }
}