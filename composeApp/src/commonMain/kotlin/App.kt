import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import data.database.TrafficDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.navigation.NavHostMain

@Composable
@Preview
fun App(databaseBuilder: RoomDatabase.Builder<TrafficDatabase>) {
    val database = remember { getRoomDatabase(databaseBuilder) }

    MaterialTheme {

        NavHostMain()
    }
}

fun getRoomDatabase(
    builder: RoomDatabase.Builder<TrafficDatabase>
): TrafficDatabase {
    return builder
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}