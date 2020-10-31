package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlin.Result.Companion.success
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var rollButton: Button
    private lateinit var resultImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollButton = findViewById(R.id.roll_button)
        resultImage = findViewById(R.id.dice_image)
        rollDice()

        rollButton.setOnClickListener {
            rollDice()
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun rollDice() {
        val randomInt = Random.nextInt(1, 7)
        resultImage.setImageResource(drawableDiceFace(randomInt))
    }

    private fun drawableDiceFace(diceFace: Int): Int {
        return when(diceFace) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
    }
}