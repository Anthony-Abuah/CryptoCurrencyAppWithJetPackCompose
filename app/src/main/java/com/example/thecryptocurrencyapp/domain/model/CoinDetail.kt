package com.example.thecryptocurrencyapp.domain.model

import com.example.thecryptocurrencyapp.data.remote.dto.TeamMember

data class CoinDetail (
    val description: String,
    val coinId: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val tags: List<String>,
    val teams: List<TeamMember>,
    val type: String
)
