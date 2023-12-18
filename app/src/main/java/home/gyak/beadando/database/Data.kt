package home.gyak.beadando.database

import android.content.ContentValues
import android.content.Context
import android.util.Log

class Data private constructor() {
    private lateinit var dbHelper: DatabaseHelper

    var waterGoal: Int = 5000
    var water:Int = 2000
    var calorieGoal: Int = 0
    var calorieBurnGoal: Int = 0
    var calorieCompleted:Int = 0
    var bwGoal: Int = 0
    var bw: Int = 0
    var cardioMinutesGoal:Int = 0
    var cardioMinutesCompleted:Int = 0
    var isThereCardioGoal: Boolean = false
    var isThereWeightliftingGoal: Boolean = false

    companion object {
        private var instance: Data? = null

        fun getInstance(): Data {
            if (instance == null) {
                instance = Data()
            }
            return instance!!
        }
    }

    public fun insertData(context: Context, waterGoal:Int?, water:Int?, calorieGoal: Int?, calorieBurnGoal: Int?, calorieCompleted:Int?,
                           bwGoal: Int?, bw: Int?, cardioMinutesGoal:Int?, cardioMinutesCompleted:Int?, isThereCardioGoal: Int?, isThereWeightliftingGoal: Int?) {
        dbHelper = DatabaseHelper(context)
        val db = dbHelper.writableDatabase

        db.beginTransaction()
        try {
            val values = ContentValues().apply {
                put(DatabaseHelper.COLUMN_WATER_GOAL, waterGoal)
                put(DatabaseHelper.COLUMN_WATER, water)
                put(DatabaseHelper.COLUMN_CALORIE_GOAL, calorieGoal)
                put(DatabaseHelper.COLUMN_CALORIE_BURN_GOAL, calorieBurnGoal)
                put(DatabaseHelper.COLUMN_CALORIE_COMPLETED, calorieCompleted)
                put(DatabaseHelper.COLUMN_BW_GOAL, bwGoal)
                put(DatabaseHelper.COLUMN_BW, bw)
                put(DatabaseHelper.COLUMN_CARDIO_MINUTES_GOAL, cardioMinutesGoal)
                put(DatabaseHelper.COLUMN_CARDIO_MINUTES_COMPLETED, cardioMinutesCompleted)
                put(DatabaseHelper.COLUMN_ISTHERECARDIOGOAL, isThereCardioGoal)
                put(DatabaseHelper.COLUMN_ISTHEREWEIGHTLIFTINGGOAL, isThereWeightliftingGoal)
            }
            val newRowId = db.insert(DatabaseHelper.TABLE_NAME, null, values)

            if (newRowId != -1L) {
                Log.d("DisplayActivity", "Data inserted successfully. Row ID: $newRowId")
                db.setTransactionSuccessful()  // Commit
            } else {
                Log.e("DisplayActivity", "Failed to insert data.")
            }
        } finally {
            db.endTransaction()
        }
    }

    public fun getData(context: Context) {
        dbHelper = DatabaseHelper(context)
        val db = dbHelper.readableDatabase

        val data = dbHelper.getAllData().last()

        waterGoal = data.waterGoal
        water = data.water
        calorieGoal = data.calorieGoal
        calorieBurnGoal = data.calorieBurnGoal
        calorieCompleted = data.calorieCompleted
        bwGoal = data.bwGoal
        bw = data.bw
        cardioMinutesGoal = data.cardioMinutesGoal
        cardioMinutesCompleted = data.cardioMinutesCompleted
        val cgoal = data.isThereCardioGoal
        val wlgoal = data.isThereWeightliftingGoal
        isThereCardioGoal = cgoal == 1
        isThereWeightliftingGoal = wlgoal == 1
    }
}