package home.gyak.beadando.menu_buttons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import home.gyak.beadando.R
import home.gyak.beadando.database.Data

class BodyweightActivity : AppCompatActivity() {
    private lateinit var data: Data
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bodyweight)

        data = Data.getInstance()

        updateUI()
    }

    private fun updateUI() {
        val goal = findViewById<TextView>(R.id.textView_bw_goalValue)
        val current = findViewById<TextView>(R.id.textView_bw_currentValue)
        val cutOrBulk = findViewById<TextView>(R.id.textView_bw_cutorbulk)

        goal.setText(data.bwGoal.toString())
        current.setText(data.bw.toString())

        if (data.bw > data.bwGoal) {
            cutOrBulk.setText("Cut")
        } else {
            cutOrBulk.setText("Bulk")
        }
    }
}