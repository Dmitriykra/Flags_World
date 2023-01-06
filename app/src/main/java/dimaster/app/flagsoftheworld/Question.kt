package dimaster.app.flagsoftheworld

data class Question(
    val id: Int,
    val question: String,
    val image: Int,
    val one: String,
    val two:String,
    val three:String,
    val four:String,
    val correctAnswer: Int
)
