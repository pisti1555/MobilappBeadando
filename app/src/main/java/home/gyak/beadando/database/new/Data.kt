package home.gyak.beadando.database.new

import android.os.Parcelable
import java.io.Serializable
import java.time.LocalDate

class Data private constructor() {
    var waterGoal: Int = 5
    var water:Int = 2
    var calorieGoal: Int = 0
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
}
