package home.gyak.beadando.menu_buttons.goals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import home.gyak.beadando.R
import home.gyak.beadando.database.new.Data

class CardioGoals : AppCompatActivity() {

    private lateinit var data: Data
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cardio_goals)

        data = Data.getInstance()

        val dailyCardioGoal = findViewById<EditText>(R.id.editTextNumberDecimal_dailyCardioGoal)
        val dailyCardioCalburnGoal = findViewById<EditText>(R.id.editTextNumberDecimal_dailyCardioCalorieGoal)
        val editButton = findViewById<Button>(R.id.button_cardioGoalEdit)

        updateUI()

        editButton.setOnClickListener {
            if(!dailyCardioGoal.isEnabled) {
                editButton.text = getString(R.string.ok)
                dailyCardioGoal.isEnabled = true
                dailyCardioCalburnGoal.isEnabled = true

                saveData()
            } else {
                editButton.text = getString(R.string.edit)
                dailyCardioGoal.isEnabled = false
                dailyCardioCalburnGoal.isEnabled = false

                saveData()
            }
        }
    }

    private fun updateUI() {
        val dailyCardioGoal = findViewById<EditText>(R.id.editTextNumberDecimal_dailyCardioGoal)
        val dailyCardioCalburnGoal = findViewById<EditText>(R.id.editTextNumberDecimal_dailyCardioCalorieGoal)
        dailyCardioGoal.setText(data.cardioMinutesGoal.toString())
        dailyCardioCalburnGoal.setText(data.calorieBurnGoal.toString())
    }

    private fun saveData() {
        val dailyCardioGoal = findViewById<EditText>(R.id.editTextNumberDecimal_dailyCardioGoal)
        val dailyCardioCalburnGoal = findViewById<EditText>(R.id.editTextNumberDecimal_dailyCardioCalorieGoal)

        data.cardioMinutesGoal = dailyCardioGoal.text.toString().toInt()
        data.calorieBurnGoal = dailyCardioCalburnGoal.text.toString().toInt()
    }
}