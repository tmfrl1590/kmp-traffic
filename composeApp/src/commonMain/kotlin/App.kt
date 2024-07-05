import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.navigation.NavHostMain

@Composable
@Preview
fun App() {
    MaterialTheme {

        NavHostMain()
    }
}