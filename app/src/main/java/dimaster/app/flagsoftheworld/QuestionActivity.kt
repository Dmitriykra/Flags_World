package dimaster.app.flagsoftheworld

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuestionActivity : AppCompatActivity(), View.OnClickListener{

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQest: TextView? = null
    private var ivImage: ImageView? = null
    private var tvOne:TextView? = null
    private var tvTwo:TextView? = null
    private var tvThree:TextView? = null
    private var tvFour:TextView? = null
    private var mCurrentPosition: Int = 1
    private var myQuestionArrayList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var submitBtn: Button? = null
    private var myUserName: String? = null
    private var myCorrectAnswers: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        myUserName = intent.getStringExtra(Constants.USER_NAME)
        progressBar = findViewById(R.id.progress_horizontal)
        tvProgress = findViewById(R.id.question_counter_tv)
        tvQest = findViewById(R.id.question_tv)
        ivImage = findViewById(R.id.imageView)
        tvOne = findViewById(R.id.tv_options_one)
        tvTwo = findViewById(R.id.tv_options_two)
        tvThree = findViewById(R.id.tv_options_three)
        tvFour = findViewById(R.id.tv_options_four)
        submitBtn = findViewById(R.id.btn_submit)

        tvOne?.setOnClickListener(this)
        tvTwo?.setOnClickListener(this)
        tvThree?.setOnClickListener(this)
        tvFour?.setOnClickListener(this)
        submitBtn?.setOnClickListener(this)

        myQuestionArrayList = Constants.getQuestion()

        setQuestion()
    }

    private fun setQuestion() {
        defaultOptionsSelect()
        //to get first position in arrayList, that is 0
        val currentQuestion: Question = myQuestionArrayList!![mCurrentPosition - 1]
        //set image
        ivImage?.setImageResource(currentQuestion.image)
        //set progress bar
        progressBar?.progress = mCurrentPosition
        //set text fro progressbar
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        //set question text
        tvQest?.text = currentQuestion.question
        //set all buttons textview
        tvOne?.text = currentQuestion.one
        tvTwo?.text = currentQuestion.two
        tvThree?.text = currentQuestion.three
        tvFour?.text = currentQuestion.four

        //if(mCurrentPosition == myQuestionArrayList!!.size){



    }

    private fun defaultOptionsSelect(){
        val options = ArrayList<TextView>()
        tvOne?.let {
            options.add(0, it)
        }

        tvTwo?.let {
            options.add(1, it)
        }
        tvThree?.let {
            options.add(2, it)
        }

        tvFour?.let {
            options.add(3, it)
        }

        for(i in options){
            i.setTextColor(Color.parseColor("#8F8F8F"))
            i.typeface = Typeface.DEFAULT
            i.background = ContextCompat.getDrawable(
                this, R.drawable.my_button_bg
            )
        }
        submitBtn?.text="Submit"
    }

    private fun selectedOptionView(tv:TextView, selectedOptionNumber: Int){
        defaultOptionsSelect()
        mSelectedOptionPosition = selectedOptionNumber
        tv.setTextColor(Color.parseColor("#3F51B5"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.select_button_bg
        )
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_options_one -> {
                tvOne?.let{
                    selectedOptionView(it, 1)
                }
            }

            R.id.tv_options_two -> {
                tvTwo?.let{
                    selectedOptionView(it, 2)
                }
            }

            R.id.tv_options_three -> {
                tvThree?.let{
                    selectedOptionView(it, 3)
                }
            }
            R.id.tv_options_four -> {
                tvFour?.let{
                    selectedOptionView(it, 4)
                }
            }

            R.id.btn_submit -> {

                if(mSelectedOptionPosition == 0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition<=myQuestionArrayList!!.size->{
                            setQuestion()
                        }
                        else ->{
                            val intent = Intent(this, FinishQuizActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, myUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, myCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, myQuestionArrayList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = myQuestionArrayList?.get(mCurrentPosition-1)

                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option)
                    } else {
                        myCorrectAnswers++
                    }

                    answerView(question.correctAnswer, R.drawable.correct_option)
                    if(mCurrentPosition == myQuestionArrayList!!.size){
                        submitBtn?.text="Finish Quiz"
                    } else {
                        submitBtn?.text="Go to ${mCurrentPosition+1} Question"
                    }
                     mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                tvOne?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

            2 -> {
                tvTwo?.background = ContextCompat.getDrawable(
                    this@QuestionActivity, drawableView
                )
            }
            3 -> {
                tvThree?.background = ContextCompat.getDrawable(
                    this@QuestionActivity, drawableView
                )
            }

            4 -> {
                tvFour?.background = ContextCompat.getDrawable(
                    this@QuestionActivity, drawableView
                )
            }
        }
    }
}