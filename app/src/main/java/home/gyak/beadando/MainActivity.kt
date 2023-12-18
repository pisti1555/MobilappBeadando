package home.gyak.beadando

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import home.gyak.beadando.database.Data
import home.gyak.beadando.menu_buttons.BodyweightActivity
import home.gyak.beadando.menu_buttons.excersize.ExerciseActivity
import home.gyak.beadando.menu_buttons.FoodActivity
import home.gyak.beadando.menu_buttons.goals.GoalsActivity
import home.gyak.beadando.menu_buttons.WaterActivity

class MainActivity : AppCompatActivity() {
    private lateinit var data: Data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        data = Data.getInstance()
        data.getData(this)

        val foodImage = findViewById<ImageView>(R.id.imageView_food)
        val waterImage = findViewById<ImageView>(R.id.imageView_water)
        val weightImage = findViewById<ImageView>(R.id.imageView_weight)
        val excersizeImage = findViewById<ImageView>(R.id.imageView_excersize)
        val goalsButton = findViewById<Button>(R.id.button_goals)

        foodImage.setOnClickListener {
            val intent = Intent(this, FoodActivity::class.java)
            startActivity(intent)
        }

        waterImage.setOnClickListener {
            val intent = Intent(this, WaterActivity::class.java)
            startActivity(intent)
        }

        weightImage.setOnClickListener {
            val intent = Intent(this, BodyweightActivity::class.java)
            startActivity(intent)
        }

        excersizeImage.setOnClickListener {
            val intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)
        }

        goalsButton.setOnClickListener {
            val intent = Intent(this, GoalsActivity::class.java)
            startActivity(intent)
        }
    }
}