package home.gyak.beadando.menu_buttons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import home.gyak.beadando.R
import home.gyak.beadando.database.new.Data

class WaterActivity : AppCompatActivity() {
    private lateinit var data: Data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water)

        data = Data.getInstance()

        val goal = findViewById<TextView>(R.id.textView_water_dailyGoalValue)
        val completed = findViewById<TextView>(R.id.textView_water_completedValue)
        val remaining = findViewById<TextView>(R.id.textView_water_remainingValue)
        val progressbar = findViewById<ProgressBar>(R.id.progressBar_water)

        var goalVal = data.waterGoal
        var completedVal = data.water
        var remainingVal = goalVal-completedVal

        goal.setText(goalVal.toString())
        completed.setText(completedVal.toString())
        remaining.setText(remainingVal.toString())

        progressbar.max = goalVal
        progressbar.progress = completedVal

    }
}