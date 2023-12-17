package home.gyak.beadando.menu_buttons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import home.gyak.beadando.R
import home.gyak.beadando.database.new.Data

class BodyweightActivity : AppCompatActivity() {
    private lateinit var data: Data
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bodyweight)

        data = Data.getInstance()
    }
}