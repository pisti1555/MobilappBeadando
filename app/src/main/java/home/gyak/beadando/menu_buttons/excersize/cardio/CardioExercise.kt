package home.gyak.beadando.menu_buttons.excersize.cardio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import home.gyak.beadando.R
import home.gyak.beadando.database.new.Data

class CardioExercise : AppCompatActivity() {
    private lateinit var data: Data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cardio_exercise)
        data = Data.getInstance()

        val addButton = findViewById<Button>(R.id.button_cardio_addActivity)
        var adderShows = false

        updateUI()

        addButton.setOnClickListener {
            val textwalking = findViewById<TextView>(R.id.textView_cardio_walking)
            val textrunning = findViewById<TextView>(R.id.textView_cardio_running)
            val textcycling = findViewById<TextView>(R.id.textView_cardio_cycling)
            val textwm = findViewById<TextView>(R.id.textView_cardio_wm)
            val textrm = findViewById<TextView>(R.id.textView_cardio_rm)
            val textcm = findViewById<TextView>(R.id.textView_cardio_cm)

            val editWalking = findViewById<EditText>(R.id.editTextNumberDecimal_cardio_walking)
            val editRunning = findViewById<EditText>(R.id.editTextNumberDecimal_cardio_running)
            val editCycling = findViewById<EditText>(R.id.editTextNumberDecimal_cardio_cycling)

            if(!adderShows) {
                textwalking.isVisible = true
                textrunning.isVisible = true
                textcycling.isVisible = true
                textwm.isVisible = true
                textrm.isVisible = true
                textcm.isVisible = true

                editWalking.isVisible = true
                editWalking.isEnabled = true
                editRunning.isVisible = true
                editRunning.isEnabled = true
                editCycling.isVisible = true
                editCycling.isEnabled = true

                addButton.setText("Save")
                adderShows = true

                saveData()
                updateUI()
            } else {
                textwalking.isVisible = false
                textrunning.isVisible = false
                textcycling.isVisible = false
                textwm.isVisible = false
                textrm.isVisible = false
                textcm.isVisible = false

                editWalking.isVisible = false
                editWalking.isEnabled = false
                editRunning.isVisible = false
                editRunning.isEnabled = false
                editCycling.isVisible = false
                editCycling.isEnabled = false

                addButton.setText("Add")
                adderShows = false

                saveData()
                updateUI()
            }
        }
    }

    private fun updateUI() {
        val timegoal = findViewById<TextView>(R.id.textView_cardio_timegoalValue)
        val timespent = findViewById<TextView>(R.id.textView_cardio_timespentValue)
        val calburngoal = findViewById<TextView>(R.id.textView_cardio_caloriegoalValue)
        val calburnt = findViewById<TextView>(R.id.textView_cardio_caloriesburntValue)

        val progressbarTime = findViewById<ProgressBar>(R.id.progressBar_cardio_time)
        val progressbarCals = findViewById<ProgressBar>(R.id.progressBar_cardio_calories)

        timegoal.setText(data.cardioMinutesGoal.toString() + " min")
        timespent.setText(data.cardioMinutesCompleted.toString() + " min")
        calburngoal.setText(data.calorieBurnGoal.toString() + " kcal")
        calburnt.setText(data.calorieCompleted.toString() + " kcal")

        progressbarTime.max = data.cardioMinutesGoal
        progressbarTime.progress = data.cardioMinutesCompleted

        progressbarCals.max = data.calorieGoal
        progressbarCals.progress = data.calorieCompleted
    }

    private fun saveData() {
        val editWalking = findViewById<EditText>(R.id.editTextNumberDecimal_cardio_walking)
        val editRunning = findViewById<EditText>(R.id.editTextNumberDecimal_cardio_running)
        val editCycling = findViewById<EditText>(R.id.editTextNumberDecimal_cardio_cycling)
        var minutesWalk = 0
        var minutesRun = 0
        var minutesCycle = 0
        var calsWalk = 0
        var calsRun = 0
        var calsCycle = 0

        if (editWalking.text.isNotEmpty()) {
            minutesWalk = editWalking.text.toString().toInt()
            calsWalk = walk(minutesWalk)
        }
        if (editRunning.text.isNotEmpty()) {
            minutesRun = editRunning.text.toString().toInt()
            calsRun = run(minutesRun)
        }
        if (editCycling.text.isNotEmpty()) {
            minutesCycle = editCycling.text.toString().toInt()
            calsCycle = cycle(minutesCycle)
        }

        val totalMinutes = minutesWalk + minutesRun + minutesCycle
        val totalCalsBurned = calsWalk + calsRun + calsCycle

        data.cardioMinutesCompleted += totalMinutes
        data.calorieCompleted += totalCalsBurned
    }

    private fun walk(min:Int):Int {
        return min * 4
    }

    private fun run(min:Int):Int {
        return min * 11
    }

    private fun cycle(min:Int):Int {
        return min * 7
    }
}