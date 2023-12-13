package home.gyak.beadando.menu_buttons.goals

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import home.gyak.beadando.R
import home.gyak.beadando.database.new.Data

class GoalsActivity : AppCompatActivity() {
    private lateinit var data: Data
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goals)

        sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        data = loadData()

        val inputWatergoal = findViewById<TextInputEditText>(R.id.input_waterGoal)
        val inputCaloriegoal = findViewById<TextInputEditText>(R.id.input_calorieGoal)
        val inputBwgoal = findViewById<TextInputEditText>(R.id.input_bwGoal)
        val inputCurrentBw = findViewById<TextInputEditText>(R.id.input_currentBw)
        val changeGoalsButton = findViewById<Button>(R.id.button_changeGoals)

        updateUI()
/*
        inputWatergoal.setText(data.waterGoal.toString())
        inputCaloriegoal.setText(data.calorieGoal.toString())
        inputBwgoal.setText(data.bwGoal.toString())
        inputCurrentBw.setText(data.bw.toString())
*/
        changeGoalsButton.setOnClickListener {
            if(!inputWatergoal.isEnabled) {
                changeGoalsButton.text = getString(R.string.ok)
                inputWatergoal.isEnabled = true
                inputCaloriegoal.isEnabled = true
                inputBwgoal.isEnabled = true
                inputCurrentBw.isEnabled = true

                /*
                val wg = inputWatergoal.text.toString()
                val calg = inputCaloriegoal.text.toString()
                val bwg = inputBwgoal.text.toString()
                val currbw = inputCurrentBw.text.toString()

                data.waterGoal = wg.toInt()
                data.calorieGoal = calg.toInt()
                data.bwGoal = bwg.toInt()
                data.bw = currbw.toInt()
*/
                saveData()

            } else {
                changeGoalsButton.text = getString(R.string.edit)
                inputWatergoal.isEnabled = false
                inputCaloriegoal.isEnabled = false
                inputBwgoal.isEnabled = false
                inputCurrentBw.isEnabled = false

                val wg = inputWatergoal.text.toString()
                val calg = inputCaloriegoal.text.toString()
                val bwg = inputBwgoal.text.toString()
                val currbw = inputCurrentBw.text.toString()

                data.waterGoal = wg.toInt()
                data.calorieGoal = calg.toInt()
                data.bwGoal = bwg.toInt()
                data.bw = currbw.toInt()

                saveData()
            }
        }
    }

    private fun updateUI() {
        val inputWatergoal = findViewById<TextInputEditText>(R.id.input_waterGoal)
        val inputCaloriegoal = findViewById<TextInputEditText>(R.id.input_calorieGoal)
        val inputBwgoal = findViewById<TextInputEditText>(R.id.input_bwGoal)
        val inputCurrentBw = findViewById<TextInputEditText>(R.id.input_currentBw)

        inputWatergoal.setText(data.waterGoal.toString())
        inputCaloriegoal.setText(data.calorieGoal.toString())
        inputBwgoal.setText(data.bwGoal.toString())
        inputCurrentBw.setText(data.bw.toString())
    }

    private fun saveData() {
        val editor = sharedPreferences.edit()
        editor.putInt("waterGoal", data.waterGoal)
        editor.putInt("calorieGoal", data.calorieGoal)
        editor.putInt("bwGoal", data.bwGoal)
        editor.putInt("bw", data.bw)
        editor.apply()
    }

    private fun loadData(): Data {
        return Data().apply {
            waterGoal = sharedPreferences.getInt("waterGoal", 0)
            calorieGoal = sharedPreferences.getInt("calorieGoal", 0)
            bwGoal = sharedPreferences.getInt("bwGoal", 0)
            bw = sharedPreferences.getInt("bw", 0)
        }
    }
}