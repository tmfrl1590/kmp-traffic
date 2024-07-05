package presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import presentation.navigation.NavigationRouteName.MAIN_HOME
import presentation.navigation.NavigationRouteName.MAIN_STATION

object NavigationRouteName{
    const val SPLASH = "splash"
    const val MAIN_HOME = "home"
    const val MAIN_STATION = "station"
    const val MAIN_LINE = "main_line"
    const val BUS_ARRIVE = "bus_arrive"
    const val MAIN_SETTING = "setting"
}

object NavigationTitle{
    const val SPLASH = "스플래시"
    const val MAIN_HOME = "홈"
    const val MAIN_STATION = "정류장"
    const val MAIN_LINE = "노선"
    const val BUS_ARRIVE = "bus_arrive"
    const val MAIN_SETTING = "설정"
}

interface Destination {
    val route: String
    val title: String
}

sealed class SplashNav(override val route: String, override val title: String): Destination {
    data object SPLASH: SplashNav(NavigationRouteName.SPLASH, NavigationTitle.SPLASH)
}

sealed class MainNav(
    override val route: String,
    val selectedIcon : ImageVector,
    val unselectedIcon: ImageVector,
    override val title: String
): Destination {
    data object HOME: MainNav(
        route = MAIN_HOME,
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        title = NavigationTitle.MAIN_HOME
    )
    data object STATION: MainNav(
        route = MAIN_STATION,
        selectedIcon = Icons.Filled.Lock,
        unselectedIcon = Icons.Outlined.Home,
        title = NavigationTitle.MAIN_STATION
    )

    data object SETTING: MainNav(
        route = NavigationRouteName.MAIN_SETTING,
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Home,
        title = NavigationTitle.MAIN_SETTING
    )
}