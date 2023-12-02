package home.gyak.beadando

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val foodImage = findViewById<ImageView>(R.id.imageView_food)
        val waterImage = findViewById<ImageView>(R.id.imageView_water)

        foodImage.setOnClickListener {
            TODO()
        }

        waterImage.setOnClickListener {
            TODO()
        }


    }
}