package com.dlgsoft.cryptoapp.domain.use_case.get_coins

import com.dlgsoft.cryptoapp.common.Constants.ERROR_COULD_NOT_REACH_SERVER
import com.dlgsoft.cryptoapp.common.Constants.ERROR_UNEXPECTED
import com.dlgsoft.cryptoapp.common.Resource
import com.dlgsoft.cryptoapp.data.remote.dto.toCoin
import com.dlgsoft.cryptoapp.domain.model.Coin
import com.dlgsoft.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins()
            emit(Resource.Success(coins.map { it.toCoin() }))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: ERROR_UNEXPECTED))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: ERROR_COULD_NOT_REACH_SERVER))
        }
    }
}