package com.dlgsoft.cryptoapp.domain.repository

import com.dlgsoft.cryptoapp.data.remote.dto.CoinDetailDto
import com.dlgsoft.cryptoapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoin(coinId: String): CoinDetailDto
}