package com.dlgsoft.cryptoapp.data.repository

import com.dlgsoft.cryptoapp.data.remote.CoinPaprikaApi
import com.dlgsoft.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinPaprikaApi: CoinPaprikaApi
): CoinRepository {

    override suspend fun getCoins() = coinPaprikaApi.getCoins()

    override suspend fun getCoin(coinId: String) = coinPaprikaApi.getCoin(coinId)
}