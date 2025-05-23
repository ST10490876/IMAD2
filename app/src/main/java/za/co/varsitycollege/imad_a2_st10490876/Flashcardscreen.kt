package za.co.varsitycollege.imad_a2_st10490876

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class Flashcardscreen: AppCompatActivity() {
    @SuppressLint("MissingIntflatedId")

    //declaration of array of questions that will be displayed
    val questions = arrayOf(
        "Question 1: The American Civil War started in 1865",
        "Question 2: The French Revolution took place in the 18th century",
        "Question 3: The Berlin Wall was erected in 1989",
        "Question 4: World War I ended in 1914",
        "Question 5: The Soviet Union dissolved in 1992"
    )

    //
    val answers = arrayOf(
        false,
        true,
        false,
        false,
        false
    )

    //setting index to start at 0 when going through array
   var currentQuestionIndex = 0

    //setting counter for score to 0
    var score = 0



    @SuppressLint("MissingInflateId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flashcardscreen)


        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
        val nextButton = findViewById<Button>(R.id.nextButton)
        val handler = Handler(Looper.getMainLooper())




        showQuestion()

        //opening coding for true button
        trueButton?.setOnClickListener {
            Toast.makeText(
                this@Flashcardscreen,
                "True Button Clicked", Toast.LENGTH_LONG
            ).show()
            checkAnswer(true)

        }

        //opening code for false button
        falseButton?.setOnClickListener {
            Toast.makeText(
                this@Flashcardscreen,
                "False Button Clicked", Toast.LENGTH_LONG
            ).show()
            checkAnswer(false)

        }

        //opening code for next button
        nextButton?.setOnClickListener {
            Toast.makeText(
                this@Flashcardscreen,
                "next page", Toast.LENGTH_LONG
            ).show()


        //code that once the button is clicked will take the user back to the welcome page
        val intent = Intent(this,Results::class.java)

            startActivity(intent)
    }
}




    //initializing textview id to be used in code

    private fun showQuestion() {
        val questionTextView =findViewById<TextView>(R.id.questionTextView)
        val currentQuestionIndex = null
        val questions = null
        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
        val nextButton = findViewById<Button>(R.id.nextButton)
        if (currentQuestionIndex = questions.size) {
            questionTextView.text = questions[currentQuestionIndex]
        } else {
            questionTextView.text = "Quiz Completed"
        }
    }

    private fun checkAnswer(userAnswer:Boolean){
        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
        val nextButton = findViewById<Button>(R.id.nextButton)
        val currentQuestionIndex
        val right = answers[currentQuestionIndex]

        if (userAnswer == right){
            score++
            Toast.makeText(this,"Correct",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this,"Incorrect", Toast.LENGTH_LONG).show()
        }
        val trueButton.isEnabled = false
        val falseButton.isEnabled = false


        handler.postDelayed({
            currentQuestionIndex++

            if (currentQuestionIndex < questions.size) {
                showQuestion()
                trueButton.isEnabled = true
                falseButton.isEnabled = true
            } else {
                val intent = Intent(this, Results::class.java)
                intent.putextra("score", score)
                startActivity(intent)
                finish()
            }
        },1000)









        }
    }





