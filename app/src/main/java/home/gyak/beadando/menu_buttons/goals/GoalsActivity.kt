package home.gyak.beadando.menu_buttons.goals

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Switch
import androidx.core.view.isVisible
import com.google.android.material.textfield.TextInputEditText
import home.gyak.beadando.R
import home.gyak.beadando.database.Data
import home.gyak.beadando.database.DatabaseHelper


/**
 * TODO: A két gombot kössem majd a switch.isChecked-hez inkább
 */
class GoalsActivity : AppCompatActivity() {
    private lateinit var data: Data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goals)

        data = Data.getInstance()

        val inputWatergoal = findViewById<TextInputEditText>(R.id.input_waterGoal)
        val inputCaloriegoal = findViewById<TextInputEditText>(R.id.input_calorieGoal)
        val inputBwgoal = findViewById<TextInputEditText>(R.id.input_bwGoal)
        val inputCurrentBw = findViewById<TextInputEditText>(R.id.input_currentBw)
        val changeGoalsButton = findViewById<Button>(R.id.button_changeGoals)
        val cardioSwitch = findViewById<Switch>(R.id.switch_cardioGoal)
        val liftingSwitch = findViewById<Switch>(R.id.switch_weightliftingGoal)
        val cardioButton = findViewById<Button>(R.id.button_seeCardioGoals)
        val liftingButton = findViewById<Button>(R.id.button_seeWeightliftingGoals)

        updateUI()

        changeGoalsButton.setOnClickListener {
            if(!inputWatergoal.isEnabled) {
                changeGoalsButton.text = getString(R.string.ok)
                inputWatergoal.isEnabled = true
                inputCaloriegoal.isEnabled = true
                inputBwgoal.isEnabled = true
                inputCurrentBw.isEnabled = true
                cardioSwitch.isEnabled = true
                liftingSwitch.isEnabled = true

                saveData()
            } else {
                changeGoalsButton.text = getString(R.string.edit)
                inputWatergoal.isEnabled = false
                inputCaloriegoal.isEnabled = false
                inputBwgoal.isEnabled = false
                inputCurrentBw.isEnabled = false
                cardioSwitch.isEnabled = false
                liftingSwitch.isEnabled = false

                saveData()
            }
        }

        cardioSwitch.setOnCheckedChangeListener {
                buttonView, isChecked ->
            if (isChecked) {
                cardioButton.isEnabled = true
                cardioButton.isVisible = true
            } else {
                cardioButton.isEnabled = false
                cardioButton.isVisible = false
            }
        }

        liftingSwitch.setOnCheckedChangeListener {
                buttonView, isChecked ->
            if (isChecked) {
                liftingButton.isEnabled = true
                liftingButton.isVisible = true
            } else {
                liftingButton.isEnabled = false
                liftingButton.isVisible = false
            }
        }

        liftingButton.setOnClickListener {
            val intent = Intent(this, LiftingGoals::class.java)
            startActivity(intent)
        }
        
        cardioButton.setOnClickListener {
            val intent = Intent(this, CardioGoals::class.java)
            startActivity(intent)
        }
    }

    private fun updateUI() {
        val inputWatergoal = findViewById<TextInputEditText>(R.id.input_waterGoal)
        val inputCaloriegoal = findViewById<TextInputEditText>(R.id.input_calorieGoal)
        val inputBwgoal = findViewById<TextInputEditText>(R.id.input_bwGoal)
        val inputCurrentBw = findViewById<TextInputEditText>(R.id.input_currentBw)
        val cardioButton = findViewById<Button>(R.id.button_seeCardioGoals)
        val liftingButton = findViewById<Button>(R.id.button_seeWeightliftingGoals)
        val cardioSwitch = findViewById<Switch>(R.id.switch_cardioGoal)
        val liftingSwitch = findViewById<Switch>(R.id.switch_weightliftingGoal)

        inputWatergoal.setText(data.waterGoal.toString())
        inputCaloriegoal.setText(data.calorieGoal.toString())
        inputBwgoal.setText(data.bwGoal.toString())
        inputCurrentBw.setText(data.bw.toString())

        cardioButton.isEnabled = data.isThereCardioGoal
        cardioButton.isVisible = data.isThereCardioGoal
        cardioSwitch.isChecked = data.isThereCardioGoal

        liftingButton.isEnabled = data.isThereWeightliftingGoal
        liftingButton.isVisible = data.isThereWeightliftingGoal
        liftingSwitch.isChecked = data.isThereWeightliftingGoal
    }

    private fun saveData() {
        val inputWatergoal = findViewById<TextInputEditText>(R.id.input_waterGoal)
        val inputCaloriegoal = findViewById<TextInputEditText>(R.id.input_calorieGoal)
        val inputBwgoal = findViewById<TextInputEditText>(R.id.input_bwGoal)
        val inputCurrentBw = findViewById<TextInputEditText>(R.id.input_currentBw)
        val cardioSwitch = findViewById<Switch>(R.id.switch_cardioGoal)
        val liftingSwitch = findViewById<Switch>(R.id.switch_weightliftingGoal)

        data.waterGoal = inputWatergoal.text.toString().toInt()
        data.calorieGoal = inputCaloriegoal.text.toString().toInt()
        data.bwGoal = inputBwgoal.text.toString().toInt()
        data.bw = inputCurrentBw.text.toString().toInt()

        data.isThereCardioGoal = cardioSwitch.isChecked
        data.isThereWeightliftingGoal = liftingSwitch.isChecked

        updateUI()

        var cardiogoal = 0
        var wlgoal = 0
        if(data.isThereCardioGoal) cardiogoal = 1
        if(data.isThereWeightliftingGoal) wlgoal = 1

        data.insertData(this, data.waterGoal, data.water, data.calorieGoal, data.calorieBurnGoal, data.calorieCompleted,
            data.bwGoal, data.bw, data.cardioMinutesGoal, data.cardioMinutesCompleted, cardiogoal, wlgoal)
    }
}