package za.co.varsitycollege.imad_a2_st10490876

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import za.co.varsitycollege.imad_a2_st10490876.R.id.startButton

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val startButton=findViewById<Button>(startButton)

        //Initializing the process which will begin once the start button is clicked
        startButton.setOnClickListener {


            //creating a explicit intent in order to connect the welcome screen to the flash card screen
            val intent=Intent(this, Flashcardscreen::class.java)

            //starting the activity once the button is clicked
            startActivity(intent)
        }








        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}