package home.gyak.beadando.menu_buttons

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import com.google.android.material.floatingactionbutton.FloatingActionButton
import home.gyak.beadando.R
import home.gyak.beadando.database.new.Data
import home.gyak.beadando.menu_buttons.goals.GoalsActivity

class WaterActivity : AppCompatActivity() {
    private lateinit var data: Data



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water)

        data = Data.getInstance()


        val addButton = findViewById<Button>(R.id.button_addWater)

        val cupImage = findViewById<ImageView>(R.id.imageView_cup)
        val cupText = findViewById<TextView>(R.id.textView_cup)
        val glassImage = findViewById<ImageView>(R.id.imageView_glass)
        val glassText = findViewById<TextView>(R.id.textView_glass)
        val bottleImage = findViewById<ImageView>(R.id.imageView_bottle)
        val bottleText = findViewById<TextView>(R.id.textView_bottle)
        val customAdd = findViewById<TextView>(R.id.textView_customWater)

        val addCup = findViewById<FloatingActionButton>(R.id.floatingActionButton_cup)
        val addGlass = findViewById<FloatingActionButton>(R.id.floatingActionButton_glass)
        val addBottle = findViewById<FloatingActionButton>(R.id.floatingActionButton_bottle)
        val addCustom = findViewById<FloatingActionButton>(R.id.floatingActionButton_custom)
        val addCustomValue = findViewById<EditText>(R.id.editTextNumberDecimal_addManuallyWater)

        val removeCup = findViewById<FloatingActionButton>(R.id.floatingActionButton_cupRemove)
        val removeGlass = findViewById<FloatingActionButton>(R.id.floatingActionButton_glassRemove)
        val removeBottle = findViewById<FloatingActionButton>(R.id.floatingActionButton_bottleRemove)
        val removeCustom = findViewById<FloatingActionButton>(R.id.floatingActionButton_customRemove)

        updateUI()

        var isAdderVisible = false

        addButton.setOnClickListener {
            if(!isAdderVisible) {
                showAdder()
                isAdderVisible = true
                addButton.setText("Done")
            } else {
                hideAdder()
                isAdderVisible = false
                addButton.setText("+Add or -Remove")
            }
        }

        addCup.setOnClickListener {
            data.water += 160
            updateUI()
        }

        addGlass.setOnClickListener {
            data.water += 300
            updateUI()
        }

        addBottle.setOnClickListener {
            data.water += 500
            updateUI()
        }

        addCustom.setOnClickListener {
            if(addCustomValue.text.isNotEmpty()) {
                data.water += addCustomValue.text.toString().toInt()
                addCustomValue.setText("")
                updateUI()
            }
        }

        removeCup.setOnClickListener {
            data.water -= 160
            updateUI()
        }
        removeGlass.setOnClickListener {
            data.water -= 300
            updateUI()
        }

        removeBottle.setOnClickListener {
            data.water -= 500
            updateUI()
        }

        removeCustom.setOnClickListener {
            if(addCustomValue.text.isNotEmpty()) {
                data.water -= addCustomValue.text.toString().toInt()
                addCustomValue.setText("")
                updateUI()
            }
        }
    }

    private fun showAdder() {
        val cupImage = findViewById<ImageView>(R.id.imageView_cup)
        val cupText = findViewById<TextView>(R.id.textView_cup)
        val glassImage = findViewById<ImageView>(R.id.imageView_glass)
        val glassText = findViewById<TextView>(R.id.textView_glass)
        val bottleImage = findViewById<ImageView>(R.id.imageView_bottle)
        val bottleText = findViewById<TextView>(R.id.textView_bottle)
        val customAdd = findViewById<TextView>(R.id.textView_customWater)

        val addCup = findViewById<FloatingActionButton>(R.id.floatingActionButton_cup)
        val addGlass = findViewById<FloatingActionButton>(R.id.floatingActionButton_glass)
        val addBottle = findViewById<FloatingActionButton>(R.id.floatingActionButton_bottle)
        val addCustom = findViewById<FloatingActionButton>(R.id.floatingActionButton_custom)
        val addCustomValue = findViewById<EditText>(R.id.editTextNumberDecimal_addManuallyWater)

        val removeCup = findViewById<FloatingActionButton>(R.id.floatingActionButton_cupRemove)
        val removeGlass = findViewById<FloatingActionButton>(R.id.floatingActionButton_glassRemove)
        val removeBottle = findViewById<FloatingActionButton>(R.id.floatingActionButton_bottleRemove)
        val removeCustom = findViewById<FloatingActionButton>(R.id.floatingActionButton_customRemove)

        cupImage.isVisible = true
        cupText.isVisible = true
        glassImage.isVisible = true
        glassText.isVisible = true
        bottleImage.isVisible = true
        bottleText.isVisible = true
        customAdd.isVisible = true

        addCup.isVisible = true
        addCup.isEnabled = true
        addGlass.isVisible = true
        addGlass.isEnabled = true
        addBottle.isVisible = true
        addBottle.isEnabled = true
        addCustom.isVisible = true
        addCustom.isEnabled = true
        addCustomValue.isVisible = true
        addCustomValue.isEnabled = true

        removeCup.isVisible = true
        removeCup.isEnabled = true
        removeGlass.isVisible = true
        removeGlass.isEnabled = true
        removeBottle.isVisible = true
        removeBottle.isEnabled = true
        removeCustom.isVisible = true
        removeCustom.isEnabled = true
    }

    private fun hideAdder() {
        val cupImage = findViewById<ImageView>(R.id.imageView_cup)
        val cupText = findViewById<TextView>(R.id.textView_cup)
        val glassImage = findViewById<ImageView>(R.id.imageView_glass)
        val glassText = findViewById<TextView>(R.id.textView_glass)
        val bottleImage = findViewById<ImageView>(R.id.imageView_bottle)
        val bottleText = findViewById<TextView>(R.id.textView_bottle)
        val customAdd = findViewById<TextView>(R.id.textView_customWater)

        val addCup = findViewById<FloatingActionButton>(R.id.floatingActionButton_cup)
        val addGlass = findViewById<FloatingActionButton>(R.id.floatingActionButton_glass)
        val addBottle = findViewById<FloatingActionButton>(R.id.floatingActionButton_bottle)
        val addCustom = findViewById<FloatingActionButton>(R.id.floatingActionButton_custom)
        val addCustomValue = findViewById<EditText>(R.id.editTextNumberDecimal_addManuallyWater)

        val removeCup = findViewById<FloatingActionButton>(R.id.floatingActionButton_cupRemove)
        val removeGlass = findViewById<FloatingActionButton>(R.id.floatingActionButton_glassRemove)
        val removeBottle = findViewById<FloatingActionButton>(R.id.floatingActionButton_bottleRemove)
        val removeCustom = findViewById<FloatingActionButton>(R.id.floatingActionButton_customRemove)

        cupImage.isVisible = false
        cupText.isVisible = false
        glassImage.isVisible = false
        glassText.isVisible = false
        bottleImage.isVisible = false
        bottleText.isVisible = false
        customAdd.isVisible = false

        addCup.isVisible = false
        addCup.isEnabled = false
        addGlass.isVisible = false
        addGlass.isEnabled = false
        addBottle.isVisible = false
        addBottle.isEnabled = false
        addCustom.isVisible = false
        addCustom.isEnabled = false
        addCustomValue.isVisible = false
        addCustomValue.isEnabled = false

        removeCup.isVisible = false
        removeCup.isEnabled = false
        removeGlass.isVisible = false
        removeGlass.isEnabled = false
        removeBottle.isVisible = false
        removeBottle.isEnabled = false
        removeCustom.isVisible = false
        removeCustom.isEnabled = false
    }

    private fun updateUI() {
        val goal = findViewById<TextView>(R.id.textView_water_dailyGoalValue)
        val completed = findViewById<TextView>(R.id.textView_water_completedValue)
        val remaining = findViewById<TextView>(R.id.textView_water_remainingValue)
        val progressbar = findViewById<ProgressBar>(R.id.progressBar_water)

        var goalVal = data.waterGoal
        var completedVal = data.water
        var remainingVal = goalVal-completedVal

        goal.setText(goalVal.toString())
        completed.setText(completedVal.toString())

        if(remainingVal > 0) {
            remaining.setText(remainingVal.toString())
        } else {
            remaining.setText("Complete")
        }

        progressbar.max = goalVal
        progressbar.progress = completedVal
    }
}