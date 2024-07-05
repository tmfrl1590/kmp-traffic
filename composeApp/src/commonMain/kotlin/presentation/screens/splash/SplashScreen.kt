package presentation.screens.splash

import SharedFileReader
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import data.database.TrafficDatabase
import data.database.entity.toStationEntity
import domain.model.Test
import kmp_traffic.composeapp.generated.resources.Res
import kmp_traffic.composeapp.generated.resources.main_bus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.painterResource
import presentation.navigation.MainNav

@Composable
fun SplashScreen(
    navController: NavHostController,
    splashViewModel: SplashViewModel,
    database: TrafficDatabase,
) {
    val isFirstLogin by splashViewModel.isFirstLogin.collectAsState()

    LaunchedEffect(Unit){
        splashViewModel.checkFirstLogin()
    }

    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.5f,
            animationSpec = tween(
                durationMillis = 1000,
            )
        )

        delay(1500L)

        if(!isFirstLogin){ // 첫로그인이면 파일 데이터 읽어서 room 저장
            println("isFirstLogin : $isFirstLogin")
            val test = loadFile()
            launch(Dispatchers.IO) {
                test?.STATION_LIST?.forEach {
                    database.stationDao().insertStation(it.toStationEntity())
                }
                println("테스트!! ${test?.RESULT}")
            }

            splashViewModel.setUpFirstLogin()

            navController.popBackStack()
            navController.navigate(MainNav.HOME.route)
        }else {
            println("isFirstLogin : $isFirstLogin")
            navController.popBackStack()
            navController.navigate(MainNav.HOME.route)
        }
    }

    SplashBackground(scale)
}

@Composable
fun SplashBackground(
    scale: Animatable<Float, AnimationVector1D>
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ){
        Image(
            modifier = Modifier
                .size(300.dp)
                .scale(scale.value),
            painter = painterResource(Res.drawable.main_bus),
            contentDescription = ""
        )
    }
}

private val sharedFileReader = SharedFileReader()
fun loadFile(): Test? {
    val jsonString = sharedFileReader.loadFile("")
    val stationModel = Json.decodeFromString<Test>(jsonString)

    return try {
        stationModel

    } catch (e: Exception) {
        null
    }
}