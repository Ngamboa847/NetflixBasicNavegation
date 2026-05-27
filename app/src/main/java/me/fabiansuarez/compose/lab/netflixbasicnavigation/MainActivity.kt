package me.fabiansuarez.compose.lab.netflixbasicnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.fabiansuarez.compose.lab.netflixbasicnavigation.ui.screen.LoginScreen
import me.fabiansuarez.compose.lab.netflixbasicnavigation.ui.screen.RegisterScreen
import me.fabiansuarez.compose.lab.netflixbasicnavigation.ui.screen.RegisterStep2Screen
import me.fabiansuarez.compose.lab.netflixbasicnavigation.ui.screen.RegisterStep3Screen
import me.fabiansuarez.compose.lab.netflixbasicnavigation.ui.theme.NetflixBasicNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val MyNavController = rememberNavController()
            NavHost(
                navController = MyNavController,
                startDestination = "login",
                modifier = Modifier.fillMaxSize()
            ){
                composable(route=Routes.LOGIN){
                    LoginScreen(
                        onClickSuscribirse = {
                            MyNavController.navigate(Routes.REGISTER)
                        }
                    )
                }
                composable(route=Routes.REGISTER){
                    RegisterScreen(
                        onClickVolver = {
                            MyNavController.popBackStack()
                        },
                        onClickSiguiente = {
                            MyNavController.navigate(Routes.REGISTER_STEP_2)
                        }

                    )
                }
                composable(route=Routes.REGISTER_STEP_2){
                    RegisterStep2Screen(
                        onClickVolve = {
                            MyNavController.popBackStack()
                        },
                        onClickSiguient = {
                            MyNavController.navigate(Routes.REGISTER_STEP_3)
                        }
                    )
                }
                composable(route=Routes.REGISTER_STEP_3){
                    RegisterStep3Screen(
                        onClickVolver = {
                            MyNavController.popBackStack()
                        }
                    )
                }
            }
        }
    }

}

object Routes{
    const val LOGIN = "login"
    const val REGISTER = "register"
    const val REGISTER_STEP_2 = "register_step_2"
    const val REGISTER_STEP_3 = "register_step_3"
}