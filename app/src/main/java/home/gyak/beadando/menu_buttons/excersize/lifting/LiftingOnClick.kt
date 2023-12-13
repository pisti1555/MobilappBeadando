package home.gyak.beadando.menu_buttons.excersize.lifting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import home.gyak.beadando.R

class LiftingOnClick : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifting_on_click)

        val okButton = findViewById<Button>(R.id.button_liftingOnClick_OK)
        val weightUsed = findViewById<EditText>(R.id.editTextNumber_liftingOnClick_weightUsed)
        val repsDone = findViewById<EditText>(R.id.editTextNumberDecimal_liftingOnClick_repsDone)

        okButton.setOnClickListener {
            // TODO:
            finish()
        }
    }
}