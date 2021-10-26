package com.plcoding.cryptocurrencyappyt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plcoding.cryptocurrencyappyt.presentation.Screen
import com.plcoding.cryptocurrencyappyt.presentation.coin_detail.CoinDetailScreen
import com.plcoding.cryptocurrencyappyt.presentation.coin_list.CoinListScreen
import com.plcoding.cryptocurrencyappyt.presentation.ui.theme.CryptocurrencyAppYTTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppYTTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(route = Screen.CoinListScreen.route) {
                            CoinListScreen(navController)
                        }
                        composable(route = Screen.CoinDetailScreen.route + "/{coinId}") {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CoinListSc() {
    val navController = rememberNavController()
    CoinListScreen(navController = navController)
}

@Preview
@Composable
fun CoinDetailSc() {
    CoinDetailScreen()
}