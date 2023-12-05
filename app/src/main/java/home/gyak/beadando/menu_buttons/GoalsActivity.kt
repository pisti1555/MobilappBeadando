package home.gyak.beadando.menu_buttons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import home.gyak.beadando.R

class GoalsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goals)

        val inputWatergoal = findViewById<TextInputEditText>(R.id.input_waterGoal)
        val inputCaloriegoal = findViewById<TextInputEditText>(R.id.input_calorieGoal)
        val inputBwgoal = findViewById<TextInputEditText>(R.id.input_bwGoal)
        val inputCurrentBw = findViewById<TextInputEditText>(R.id.input_currentBw)
        val changeGoalsButton = findViewById<Button>(R.id.button_changeGoals)

        changeGoalsButton.setOnClickListener {
            if(!inputWatergoal.isEnabled) {
                changeGoalsButton.text = getString(R.string.ok)
                inputWatergoal.isEnabled = true
                inputCaloriegoal.isEnabled = true
                inputBwgoal.isEnabled = true
                inputCurrentBw.isEnabled = true
            } else {
                changeGoalsButton.text = getString(R.string.change_goals)
                inputWatergoal.isEnabled = false
                inputCaloriegoal.isEnabled = false
                inputBwgoal.isEnabled = false
                inputCurrentBw.isEnabled = false
            }
        }
    }
}