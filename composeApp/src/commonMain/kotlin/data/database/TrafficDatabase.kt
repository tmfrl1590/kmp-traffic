package data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import data.database.dao.StationDao
import data.database.entity.StationEntity

@Database(
    entities = [StationEntity::class],
    version = 1,
)
abstract class TrafficDatabase: RoomDatabase(), DB {
    abstract fun stationDao(): StationDao

    override fun clearAllTables() {
        super.clearAllTables()
    }
}

interface DB {
    fun clearAllTables(): Unit {}
}