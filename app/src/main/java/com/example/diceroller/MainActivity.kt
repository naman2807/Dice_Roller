package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val diceButton : Button = findViewById(R.id.button)
        diceButton.setOnClickListener {
            rollDice()
        }
        rollDice()
    }

    private fun rollDice() {
        var newDice = Dice(6)
        var value = newDice.roll()
        val diceImage : ImageView = findViewById(R.id.imageView)
        val imageToSet = when (value) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(imageToSet)
        Toast.makeText(this, "You Rolled ${value}", Toast.LENGTH_SHORT).show()
        diceImage.contentDescription = value.toString()
    }
}

class Dice(val numSides : Int) {
    fun roll() : Int{
        return (1..numSides).random()
    }
}