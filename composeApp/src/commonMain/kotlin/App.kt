import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import data.database.TrafficDatabase
import data.datastore.dataStorePreferences
import data.repository.DataStoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.navigation.NavHostMain
import presentation.screens.splash.SplashViewModel

@Composable
@Preview
fun App(databaseBuilder: RoomDatabase.Builder<TrafficDatabase>) {
    val database = remember { getRoomDatabase(databaseBuilder) }
    val dataStore = remember { DataStoreRepository(dataStorePreferences()) }
    val splashViewModel = viewModel { SplashViewModel(dataStore) }

    MaterialTheme {
        NavHostMain(
            splashViewModel = splashViewModel,
            database = database
        )
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