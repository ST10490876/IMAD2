package za.co.varsitycollege.imad_a2_st10490876

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Results : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_results)

        val scoreTextView = findViewById<TextView>(R.id.scoretextView)
        val feedbackTextView = findViewById<TextView>(R.id.feedbacktextView)
        val reviewButton = findViewById<Button>(R.id.reviewButton)
        val exitButton = findViewById<Button>(R.id.exitButton)

        val score = intent.getIntExtra("score", 0)
        scoreTextView.text = "Total Score: $score / 5"

        val feedback = when (score) {
            5 -> "Amazing"
            in 3..4 -> "Welldone"
            in 1..2 -> "You can do better"
            else -> "Go Again."
        }
        feedbackTextView.text = feedback

        reviewButton?.setOnClickListener {
            Toast.makeText(
                "Started Flashcards", Toast.LENGTH_LONG
            ).show()
        }

        val intent = Intent(this, Results::class.java)
        startActivity(intent)
    }
    //opening coding for exit button
         exitButton?setOnClickListener
    //code that once button is clicked will exit app
        finishAffinity()
    }



