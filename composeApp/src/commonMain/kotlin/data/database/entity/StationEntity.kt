package data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import domain.model.StationModel

@Entity(tableName = "station_entity")
data class StationEntity(
    @PrimaryKey
    val station_num : String,
    val busstop_name : String?,
    val next_busstop : String?,
    val busstop_id : String?,
    val ars_id : String?,
    val longitude: String?,
    val latitude: String?,
)

fun StationModel.toStationEntity(): StationEntity {
    return StationEntity(
        station_num = STATION_NUM.toString(),
        busstop_name = BUSSTOP_NAME,
        next_busstop = NEXT_BUSSTOP,
        busstop_id = BUSSTOP_ID.toString(),
        ars_id = ARS_ID,
        longitude = LONGITUDE.toString(),
        latitude = LATITUDE.toString(),
    )
}
