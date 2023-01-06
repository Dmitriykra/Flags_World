package dimaster.app.flagsoftheworld

object Constants {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    //get ArrayList  of  all val in  class Question
    fun getQuestion():ArrayList<Question>{

        //init the questionList as arrayList of Question class
        val questionList = ArrayList<Question>()

        //1
        val question1 = Question(
            1, "What country this flag belong to?",
            R.drawable.ukr,
            "Ukraine",
            "Spain",
            "Sweden",
            "United Kingdom",
            1
        )
        questionList.add(question1)

        //2
        val question2 = Question(
            1, "What country this flag belong to?",
            R.drawable.che,
            "Israel",
            "Czech",
            "USA",
            "United Kingdom",
            2
        )
        questionList.add(question2)

        //3
        val question3 = Question(
            1, "What country this flag belong to?",
            R.drawable.fra,
            "Israel",
            "Italy",
            "Spain",
            "France",
            4
        )
        questionList.add(question3)

        //4
        val question4 = Question(
            1, "What country this flag belong to?",
            R.drawable.isra,
            "Israel",
            "Ukraine",
            "USA",
            "United Kingdom",
            1
        )
        questionList.add(question4)

        //5
        val question5 = Question(
            1, "What country this flag belong to?",
            R.drawable.italy,
            "Spain",
            "Italy",
            "Sweden",
            "France",
            2
        )
        questionList.add(question5)

        //6
        val question6 = Question(
            1, "What country this flag belong to?",
            R.drawable.usa,
            "Czech",
            "Spain",
            "USA",
            "United Kingdom",
            3
        )
        questionList.add(question6)

        //7
        val question7 = Question(
            1, "What country this flag belong to?",
            R.drawable.uk,
            "United Kingdom",
            "Ukraine",
            "USA",
            "Israel",
            1
        )
        questionList.add(question7)

        //8
        val question8 = Question(
            1, "What country this flag belong to?",
            R.drawable.spain,
            "Spain",
            "Ukraine",
            "USA",
            "Israel",
            1
        )
        questionList.add(question8)

        //8
        val question9 = Question(
            1, "What country this flag belong to?",
            R.drawable.swed,
            "Spain",
            "Sweden",
            "USA",
            "Israel",
            2
        )
        questionList.add(question9)
        return questionList
    }
}