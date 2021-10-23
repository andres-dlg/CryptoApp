package com.dlgsoft.cryptoapp.data.remote

import com.dlgsoft.cryptoapp.data.remote.dto.CoinDetailDto
import com.dlgsoft.cryptoapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET(GET_COINS_PATH)
    suspend fun getCoins(): List<CoinDto>

    @GET(GET_COIN_PATH)
    suspend fun getCoin(@Path(COIN_ID) coinId: String): CoinDetailDto

    companion object {
        // Params
        private const val COIN_ID = "coinId"

        // Paths
        private const val API_VERSION = "v1"
        private const val GET_COINS_PATH = "$API_VERSION/coins"
        private const val GET_COIN_PATH = "$GET_COINS_PATH/{$COIN_ID}"
    }
}