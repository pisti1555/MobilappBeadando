package home.gyak.beadando.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "app_database"
        const val DATABASE_VERSION = 2
        const val TABLE_NAME = "my_table"
        const val COLUMN_ID = "id"
        const val COLUMN_WATER_GOAL = "waterGoal"
        const val COLUMN_WATER = "water"
        const val COLUMN_CALORIE_GOAL = "calorieGoal"
        const val COLUMN_CALORIE_BURN_GOAL = "calorieBurnGoal"
        const val COLUMN_CALORIE_COMPLETED = "calorieCompleted"
        const val COLUMN_BW_GOAL = "bwGoal"
        const val COLUMN_BW = "bw"
        const val COLUMN_CARDIO_MINUTES_GOAL = "cardioMinutesGoal"
        const val COLUMN_CARDIO_MINUTES_COMPLETED = "cardioMinutesCompleted"
        const val COLUMN_ISTHERECARDIOGOAL = "isThereCardioGoal"
        const val COLUMN_ISTHEREWEIGHTLIFTINGGOAL = "isThereWeightliftingGoal"
    }

    private val SQL_CREATE_ENTRIES = """
        CREATE TABLE $TABLE_NAME (
            $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
            $COLUMN_WATER_GOAL INTEGER,
            $COLUMN_WATER INTEGER,
            $COLUMN_CALORIE_GOAL INTEGER,
            $COLUMN_CALORIE_BURN_GOAL INTEGER,
            $COLUMN_CALORIE_COMPLETED INTEGER,
            $COLUMN_BW_GOAL INTEGER,
            $COLUMN_BW INTEGER,
            $COLUMN_CARDIO_MINUTES_GOAL INTEGER,
            $COLUMN_CARDIO_MINUTES_COMPLETED INTEGER,
            $COLUMN_ISTHERECARDIOGOAL INTEGER,
            $COLUMN_ISTHEREWEIGHTLIFTINGGOAL INTEGER
        )
    """.trimIndent()

    private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS $TABLE_NAME"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

        fun getAllData(): List<DataToSend> {
            val list = mutableListOf<DataToSend>()
            val db = readableDatabase

            val projection = arrayOf(
                COLUMN_ID,
                COLUMN_WATER_GOAL,
                COLUMN_WATER,
                COLUMN_CALORIE_GOAL,
                COLUMN_CALORIE_BURN_GOAL,
                COLUMN_CALORIE_COMPLETED,
                COLUMN_BW_GOAL,
                COLUMN_BW,
                COLUMN_CARDIO_MINUTES_GOAL,
                COLUMN_CARDIO_MINUTES_COMPLETED,
                COLUMN_ISTHERECARDIOGOAL,
                COLUMN_ISTHEREWEIGHTLIFTINGGOAL
            )

            val cursor = db?.query(
                TABLE_NAME,  // Tábla neve
                projection,  // Visszaadott oszlopok
                null,  // WHERE clause
                null,  // WHERE arguments
                null,  // GROUP BY
                null,  // HAVING
                null   // ORDER BY
            )

            cursor?.use {
                while (it.moveToNext()) {
                    val dataToSend = DataToSend(
                        it.getLong(it.getColumnIndexOrThrow(COLUMN_ID)),
                        it.getInt(it.getColumnIndexOrThrow(COLUMN_WATER_GOAL)),
                        it.getInt(it.getColumnIndexOrThrow(COLUMN_WATER)),
                        it.getInt(it.getColumnIndexOrThrow(COLUMN_CALORIE_GOAL)),
                        it.getInt(it.getColumnIndexOrThrow(COLUMN_CALORIE_BURN_GOAL)),
                        it.getInt(it.getColumnIndexOrThrow(COLUMN_CALORIE_COMPLETED)),
                        it.getInt(it.getColumnIndexOrThrow(COLUMN_BW_GOAL)),
                        it.getInt(it.getColumnIndexOrThrow(COLUMN_BW)),
                        it.getInt(it.getColumnIndexOrThrow(COLUMN_CARDIO_MINUTES_GOAL)),
                        it.getInt(it.getColumnIndexOrThrow(COLUMN_CARDIO_MINUTES_COMPLETED)),
                        it.getInt(it.getColumnIndexOrThrow(COLUMN_ISTHERECARDIOGOAL)),
                        it.getInt(it.getColumnIndexOrThrow(COLUMN_ISTHEREWEIGHTLIFTINGGOAL))
                    )
                    list.add(dataToSend)
                }
            }
            return list
        }

    }
