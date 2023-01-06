package dimaster.app.flagsoftheworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_start: Button = findViewById(R.id.btn_start)
        var name_et: EditText = findViewById(R.id.name_et)

        btn_start.setOnClickListener {
            if(name_et.text.isEmpty()){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME, name_et.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}