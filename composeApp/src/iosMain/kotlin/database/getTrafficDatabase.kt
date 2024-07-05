package database

import androidx.room.Room
import androidx.room.RoomDatabase
import data.database.TrafficDatabase
import data.database.instantiateImpl
import platform.Foundation.NSHomeDirectory

fun getDatabaseBuilder(): RoomDatabase.Builder<TrafficDatabase> {
    val dbFile = NSHomeDirectory() + "/traffic.db"
    return Room.databaseBuilder<TrafficDatabase>(
        name = dbFile,
        factory = { TrafficDatabase::class.instantiateImpl() }
    )
}