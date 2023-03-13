package com.example.thecryptocurrencyapp.domain.repository

import com.example.thecryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.example.thecryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}