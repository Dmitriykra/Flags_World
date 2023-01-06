package dimaster.app.flagsoftheworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val  questionsList = Constants.getQuestion()
        Log.d("TAG", "questionsList size: "+questionsList.size)
    }
}