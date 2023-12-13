package home.gyak.beadando.menu_buttons.excersize.lifting

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import home.gyak.beadando.menu_buttons.WaterActivity

class LiftingExercise : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(home.gyak.beadando.R.layout.activity_lifting_exercise)

        val exercises = ArrayList<String>()

        val button_benchpress = findViewById<Button>(home.gyak.beadando.R.id.button_chooseBenchPress)
        button_benchpress.setOnClickListener(this)
        val button_squat = findViewById<Button>(home.gyak.beadando.R.id.button_chooseSquat)
        button_squat.setOnClickListener(this)
        val button_deadlift = findViewById<Button>(home.gyak.beadando.R.id.button_chooseDeadlift)
        button_deadlift.setOnClickListener(this)

        val button_inclinebarbellpress = findViewById<Button>(home.gyak.beadando.R.id.button_chooseInclineBarbellPress)
        button_inclinebarbellpress.setOnClickListener(this)
        val button_barbellshoulderpress = findViewById<Button>(home.gyak.beadando.R.id.button_chooseShoulderPress)
        button_barbellshoulderpress.setOnClickListener(this)
        val button_dumbbellpress = findViewById<Button>(home.gyak.beadando.R.id.button_chooseFlatDumbbelPress)
        button_dumbbellpress.setOnClickListener(this)
        val button_inclinedumbbellpress = findViewById<Button>(home.gyak.beadando.R.id.button_chooseInclineDumbbellPress)
        button_inclinedumbbellpress.setOnClickListener(this)
        val button_dumbbellshoulderpress = findViewById<Button>(home.gyak.beadando.R.id.button_chooseDumbbellShoulderPress)
        button_dumbbellshoulderpress.setOnClickListener(this)
        val button_dumbbellfly = findViewById<Button>(home.gyak.beadando.R.id.button_chooseDumbbellFly)
        button_dumbbellfly.setOnClickListener(this)
        val button_cablefly = findViewById<Button>(home.gyak.beadando.R.id.button_chooseCableFly)
        button_cablefly.setOnClickListener(this)

        val button_pulldown = findViewById<Button>(home.gyak.beadando.R.id.button_choosePullDown)
        button_pulldown.setOnClickListener(this)
        val button_barbellrow = findViewById<Button>(home.gyak.beadando.R.id.button_chooseBarbellRow)
        button_barbellrow.setOnClickListener(this)
        val button_cablerow = findViewById<Button>(home.gyak.beadando.R.id.button_chooseCableRow)
        button_cablerow.setOnClickListener(this)

        val button_rdl = findViewById<Button>(home.gyak.beadando.R.id.button_chooseRomanianDeadlift)
        button_rdl.setOnClickListener(this)
        val button_legextension = findViewById<Button>(home.gyak.beadando.R.id.button_chooseLegExtension)
        button_legextension.setOnClickListener(this)
        val button_legcurl = findViewById<Button>(home.gyak.beadando.R.id.button_chooseLegCurl)
        button_legcurl.setOnClickListener(this)
        val button_calfraise = findViewById<Button>(home.gyak.beadando.R.id.button_chooseCalfRaise)
        button_calfraise.setOnClickListener(this)

        val button_bicepscurl = findViewById<Button>(home.gyak.beadando.R.id.button_chooseBicepsCurl)
        button_bicepscurl.setOnClickListener(this)
        val button_tricepsextension = findViewById<Button>(home.gyak.beadando.R.id.button_chooseTricepsExtension)
        button_tricepsextension.setOnClickListener(this)
        val button_lateralraise = findViewById<Button>(home.gyak.beadando.R.id.button_chooseLateralRaise)
        button_lateralraise.setOnClickListener(this)

        val button_pushup = findViewById<Button>(home.gyak.beadando.R.id.button_choosePushUp)
        val button_pullup = findViewById<Button>(home.gyak.beadando.R.id.button_choosePullUp)
        val button_dips = findViewById<Button>(home.gyak.beadando.R.id.button_chooseDips)
        val button_bodyweightsquat = findViewById<Button>(home.gyak.beadando.R.id.button_chooseBwSquat)
    }

    override fun onClick(v: View) {
        val intent = Intent(this, LiftingOnClick::class.java)
        startActivity(intent)
    }
}