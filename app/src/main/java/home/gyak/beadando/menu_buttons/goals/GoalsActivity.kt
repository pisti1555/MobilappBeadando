package home.gyak.beadando.menu_buttons.goals

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import androidx.core.view.isVisible
import com.google.android.material.textfield.TextInputEditText
import home.gyak.beadando.R
import home.gyak.beadando.database.new.Data
import home.gyak.beadando.menu_buttons.excersize.lifting.LiftingOnClick


/**
 * TODO: A két gombot kössem majd a switch.isChecked-hez inkább
 */
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
        val cardioSwitch = findViewById<Switch>(R.id.switch_cardioGoal)
        val liftingSwitch = findViewById<Switch>(R.id.switch_weightliftingGoal)
        val cardioButton = findViewById<Button>(R.id.button_seeCardioGoals)
        val liftingButton = findViewById<Button>(R.id.button_seeWeightliftingGoals)

        if(data.isThereCardioGoal) {
            cardioButton.isEnabled = true
            cardioButton.isVisible = true
            cardioSwitch.isChecked = true
        }

        if(data.isThereWeightliftingGoal) {
            liftingButton.isEnabled = true
            liftingButton.isVisible = true
            liftingSwitch.isChecked = true
        }

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

                val wg = inputWatergoal.text.toString()
                val calg = inputCaloriegoal.text.toString()
                val bwg = inputBwgoal.text.toString()
                val currbw = inputCurrentBw.text.toString()

                data.waterGoal = wg.toInt()
                data.calorieGoal = calg.toInt()
                data.bwGoal = bwg.toInt()
                data.bw = currbw.toInt()
                data.isThereWeightliftingGoal = liftingSwitch.isChecked
                data.isThereCardioGoal = cardioSwitch.isChecked

                saveData()
            }
        }

        cardioSwitch.setOnCheckedChangeListener {
                buttonView, isChecked ->
            if (isChecked) {
                cardioButton.isEnabled = true
                cardioButton.isVisible = true
                saveData()
            } else {
                cardioButton.isEnabled = false
                cardioButton.isVisible = false
                saveData()
            }
        }

        liftingSwitch.setOnCheckedChangeListener {
                buttonView, isChecked ->
            if (isChecked) {
                liftingButton.isEnabled = true
                liftingButton.isVisible = true
                saveData()
            } else {
                liftingButton.isEnabled = false
                liftingButton.isVisible = false
                saveData()
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

        inputWatergoal.setText(data.waterGoal.toString())
        inputCaloriegoal.setText(data.calorieGoal.toString())
        inputBwgoal.setText(data.bwGoal.toString())
        inputCurrentBw.setText(data.bw.toString())

        cardioButton.isEnabled = data.isThereCardioGoal
        cardioButton.isVisible = data.isThereCardioGoal

        liftingButton.isEnabled = data.isThereWeightliftingGoal
        liftingButton.isVisible = data.isThereWeightliftingGoal
    }

    private fun saveData() {
        val editor = sharedPreferences.edit()
        editor.putInt("waterGoal", data.waterGoal)
        editor.putInt("calorieGoal", data.calorieGoal)
        editor.putInt("bwGoal", data.bwGoal)
        editor.putInt("bw", data.bw)
        editor.putBoolean("isThereCardioGoal", data.isThereCardioGoal)
        editor.putBoolean("isThereWeightliftingGoal", data.isThereWeightliftingGoal)
        editor.apply()
    }

    private fun loadData(): Data {
        return Data().apply {
            waterGoal = sharedPreferences.getInt("waterGoal", 0)
            calorieGoal = sharedPreferences.getInt("calorieGoal", 0)
            bwGoal = sharedPreferences.getInt("bwGoal", 0)
            bw = sharedPreferences.getInt("bw", 0)
            isThereCardioGoal = sharedPreferences.getBoolean("isThereCardioGoal", false)
            isThereWeightliftingGoal = sharedPreferences.getBoolean("isThereWeightliftingGoal", false)
        }
    }
}