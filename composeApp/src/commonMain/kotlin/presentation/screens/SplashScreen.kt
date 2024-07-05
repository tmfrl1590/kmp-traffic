package presentation.screens

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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kmp_traffic.composeapp.generated.resources.Res
import kmp_traffic.composeapp.generated.resources.main_bus
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import presentation.navigation.MainNav

@Composable
fun SplashScreen(
    navController: NavHostController,
) {

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

        navController.popBackStack()
        navController.navigate(MainNav.HOME.route)
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