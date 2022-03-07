package com.example.muhamadsyafei_android12_chp3_firstproject

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.example.muhamadsyafei_android12_chp3_firstproject.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Mbutton.setOnClickListener {
            rollDice()
            Log.d(TAG, "just make sure its rolled")
            Toast.makeText(this, "diceRolled", Toast.LENGTH_SHORT).show()
        }

        hideToolBar()
        rollDice()
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = binding.imageView1
        val drawableResources = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResources)
        diceImage.contentDescription = diceRoll.toString()
    }

    private fun hideToolBar() {
        if (supportActionBar != null) supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.WHITE
    }
}

class Dice(val numDice: Int) {
    fun roll(): Int {
        return (1..numDice).random()
    }
}
