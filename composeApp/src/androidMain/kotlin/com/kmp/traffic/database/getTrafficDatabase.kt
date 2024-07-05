package com.kmp.traffic.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import data.database.TrafficDatabase

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<TrafficDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("traffic.db")
    return Room.databaseBuilder<TrafficDatabase>(
        context = context.applicationContext,
        name = dbFile.absolutePath
    )
}