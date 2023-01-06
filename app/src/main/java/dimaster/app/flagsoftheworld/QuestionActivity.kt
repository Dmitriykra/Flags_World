package dimaster.app.flagsoftheworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuestionActivity : AppCompatActivity() {

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQest: TextView? = null
    private var ivImage: ImageView? = null
    private var tvOne:TextView? = null
    private var tvTwo:TextView? = null
    private var tvThree:TextView? = null
    private var tvFour:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        progressBar = findViewById(R.id.progress_horizontal)
        tvProgress = findViewById(R.id.question_counter_tv)
        tvQest = findViewById(R.id.question_tv)
        ivImage = findViewById(R.id.imageView)
        tvOne = findViewById(R.id.tv_options_one)
        tvTwo = findViewById(R.id.tv_options_two)
        tvThree = findViewById(R.id.tv_options_three)
        tvFour = findViewById(R.id.tv_options_four)

        val  questionsList = Constants.getQuestion()
        Log.d("TAG", "questionsList size: "+questionsList.size)

        for(i in questionsList){
            //Log.e("TAG", "Question", i.question)
            Log.d("TAG", "questionsList size: "+i.question)
        }
        var currentPosition = 1
        val currentQuestion: Question= questionsList[currentPosition-1]
        progressBar?.progress = currentPosition
        tvProgress?.text = "$currentPosition/${progressBar?.max}"
        tvQest?.text = currentQuestion.question
        tvOne?.text = currentQuestion.one
        tvTwo?.text = currentQuestion.two
        tvThree?.text = currentQuestion.three
        tvFour?.text = currentQuestion.four
    }
}