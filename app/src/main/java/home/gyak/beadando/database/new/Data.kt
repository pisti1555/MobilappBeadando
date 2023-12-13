package home.gyak.beadando.database.new

import java.io.Serializable
import java.time.LocalDate

class Data : Serializable{
    var date = LocalDate.now()

    var waterGoal = 0
    var water = 0

    var calorieGoal = 0
    var caloriesCompleted = 0

    var cardioMinutesGoal = 0
    var cardioMinutesCompleted = 0

    var bwGoal = 0
    var bw = 0

    var isThereCardioGoal = false
    var isThereWeightliftingGoal = false
}