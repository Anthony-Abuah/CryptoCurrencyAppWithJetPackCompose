package com.example.thecryptocurrencyapp.data.repository

import com.example.thecryptocurrencyapp.data.remote.CryptoCoinsApi
import com.example.thecryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.example.thecryptocurrencyapp.data.remote.dto.CoinDto
import com.example.thecryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api : CryptoCoinsApi
) : CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}