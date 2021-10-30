package com.dlgsoft.cryptoapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dlgsoft.cryptoapp.common.Constants.PARAM_COIN_ID
import com.dlgsoft.cryptoapp.presentation.coin_detail.CoinDetailScreen
import com.dlgsoft.cryptoapp.presentation.coin_list.CoinListScreen
import com.dlgsoft.cryptoapp.presentation.ui.theme.CryptoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(
                            route = Screen.CoinListScreen.route
                        ) {
                            CoinListScreen(navController)
                        }
                        composable(
                            route = Screen.CoinDetailScreen.route + "/{$PARAM_COIN_ID}"
                        ) {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}