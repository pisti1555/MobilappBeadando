package home.gyak.beadando.menu_buttons.excersize

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import home.gyak.beadando.R
import home.gyak.beadando.menu_buttons.excersize.lifting.LiftingExercise

class ExerciseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        val cardioButton = findViewById<Button>(R.id.button_cardioExcersize)
        val weightliftingButton = findViewById<Button>(R.id.button_liftingExcersize)

        cardioButton.setOnClickListener {
            val intent = Intent(this, CardioExercise::class.java)
            startActivity(intent)
        }

        weightliftingButton.setOnClickListener {
            val intent = Intent(this, LiftingExercise::class.java)
            startActivity(intent)
        }
    }
}