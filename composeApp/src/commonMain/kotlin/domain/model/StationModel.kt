package domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Test(
    val RESULT: TestResult,
    val STATION_LIST: ArrayList<StationModel>,
    val ROW_COUNT: Int,
)

@Serializable
data class TestResult(
    val RESULT_MSG: String,
    val RESULT_CODE: String,
)

@Serializable
data class StationModel(
    val STATION_NUM : Int,
    val BUSSTOP_NAME : String,
    val ARS_ID : String? = null,
    val NEXT_BUSSTOP : String? = null,
    val BUSSTOP_ID : Int,
    val LONGITUDE: Double,
    val NAME_E: String? = null,
    val LATITUDE: Double,
)