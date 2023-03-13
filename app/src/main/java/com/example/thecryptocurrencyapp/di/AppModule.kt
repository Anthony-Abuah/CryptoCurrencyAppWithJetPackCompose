package com.example.thecryptocurrencyapp.di

import com.example.thecryptocurrencyapp.common.Constants
import com.example.thecryptocurrencyapp.data.remote.CryptoCoinsApi
import com.example.thecryptocurrencyapp.data.repository.CoinRepositoryImpl
import com.example.thecryptocurrencyapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CryptoCoinsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoCoinsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CryptoCoinsApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }

}