package home.gyak.beadando.database.new

import home.gyak.beadando.database.new.Data
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DataDao {

    @Query("SELECT * FROM Data")
    fun getAllData(): List<Data>

    @Insert
    suspend fun insertData(data: Data)
}