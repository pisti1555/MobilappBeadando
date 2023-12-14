package home.gyak.beadando.menu_buttons.goals

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText
import home.gyak.beadando.R
import home.gyak.beadando.database.new.Data

class CardioGoals : AppCompatActivity() {

    private lateinit var data: Data
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cardio_goals)

        sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        data = Data.getInstance()

        val dailyCardioGoal = findViewById<EditText>(R.id.editTextNumberDecimal_dailyCardioGoal)
        val editButton = findViewById<Button>(R.id.button_cardioGoalEdit)

        updateUI()

        editButton.setOnClickListener {
            if(!dailyCardioGoal.isEnabled) {
                editButton.text = getString(R.string.ok)
                dailyCardioGoal.isEnabled = true

                saveData()
            } else {
                editButton.text = getString(R.string.edit)
                dailyCardioGoal.isEnabled = false

                val cardioGoal = dailyCardioGoal.text.toString()
                data.cardioMinutesGoal = cardioGoal.toInt()

                saveData()
            }
        }
    }

    private fun updateUI() {
        val dailyCardioGoal = findViewById<EditText>(R.id.editTextNumberDecimal_dailyCardioGoal)
        dailyCardioGoal.setText(data.cardioMinutesGoal.toString())
    }

    private fun saveData() {
        val editor = sharedPreferences.edit()
        editor.putInt("cardioMinutesGoal", data.cardioMinutesGoal)
        editor.apply()
    }

    /*
    private fun loadData(): Data {
        return Data().apply {
            cardioMinutesGoal = sharedPreferences.getInt("cardioMinutesGoal", 0)

        }
    }

     */
}