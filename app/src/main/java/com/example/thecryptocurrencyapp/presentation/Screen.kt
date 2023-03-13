package com.example.thecryptocurrencyapp.presentation

sealed class Screen(val route: String){
    object CoinListScreen: Screen("to_coin_list_screen")
    object CoinDetailScreen: Screen("to_coin_detail_screen")
}
