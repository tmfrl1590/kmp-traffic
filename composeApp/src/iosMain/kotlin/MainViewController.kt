import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import database.getDatabaseBuilder

fun MainViewController() = ComposeUIViewController {
    val database = remember {
        getDatabaseBuilder()
    }
    App(database)
}