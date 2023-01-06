package dimaster.app.flagsoftheworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FinishQuizActivity : AppCompatActivity() {

    private lateinit var playAgainBtn: Button
    private var tvResults: TextView? = null
    private var myUserName: String? = null
    private var myCorrectAnswers: Int = 0
    private var numberOfQuestions: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish_quiz)

        playAgainBtn = findViewById(R.id.btn_play_again)
        tvResults = findViewById(R.id.your_result_tv)

        myUserName = intent.getStringExtra(Constants.USER_NAME)
        myCorrectAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        numberOfQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)

        tvResults?.text="${myUserName}, your result is $myCorrectAnswers of $numberOfQuestions"
        playAgainBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}