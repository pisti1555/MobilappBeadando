package home.gyak.beadando

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.room.Database
import androidx.room.Room
import home.gyak.beadando.database.new.AppDatabase
import home.gyak.beadando.database.new.Data
import home.gyak.beadando.menu_buttons.BodyweightActivity
import home.gyak.beadando.menu_buttons.excersize.ExerciseActivity
import home.gyak.beadando.menu_buttons.FoodActivity
import home.gyak.beadando.menu_buttons.goals.GoalsActivity
import home.gyak.beadando.menu_buttons.WaterActivity

class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var database: AppDatabase
            private set
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
/*
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database"
        ).allowMainThreadQueries().build()
*/
        setContentView(R.layout.activity_main)

        val data = Data()

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
            intent.putExtra("data", data)
            startActivity(intent)
        }
    }
}