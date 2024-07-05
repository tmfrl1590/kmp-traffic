package data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import data.database.entity.StationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StationDao {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStation(stationEntity: StationEntity)

    @Query("SELECT * FROM station_entity" )
    fun getStationList() : Flow<List<StationEntity>>

    @Query("SELECT * FROM station_entity WHERE busstop_name LIKE :text" )
    fun getSearchedStationList(text : String) : Flow<List<StationEntity>>  // 넘어오는 String 값에 %% 붙여서 보내줘야함
}