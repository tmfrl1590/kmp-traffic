package presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import presentation.screens.HomeScreen
import presentation.screens.SettingScreen
import presentation.screens.SplashScreen
import presentation.screens.StationScreen

@Composable
fun NavHostMain(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ){ innerPadding ->
        NavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            startDestination = SplashNav.SPLASH.route
        ){
            composable(route = SplashNav.SPLASH.route){
                SplashScreen(navController = navController)
            }
            composable(route = MainNav.HOME.route) {
                HomeScreen()
            }
            composable(route = MainNav.STATION.route) {
                StationScreen()
            }
            composable(route = MainNav.SETTING.route){
                SettingScreen()
            }
        }
    }
}