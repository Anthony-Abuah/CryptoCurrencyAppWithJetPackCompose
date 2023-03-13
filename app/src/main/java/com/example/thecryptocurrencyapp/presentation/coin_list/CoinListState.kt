package com.example.thecryptocurrencyapp.presentation.coin_list

import com.example.thecryptocurrencyapp.domain.model.Coin

data class CoinListState (
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String =""
)