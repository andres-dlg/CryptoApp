package com.dlgsoft.cryptoapp.domain.use_case.get_coin

import com.dlgsoft.cryptoapp.common.Constants.ERROR_COULD_NOT_REACH_SERVER
import com.dlgsoft.cryptoapp.common.Constants.ERROR_UNEXPECTED
import com.dlgsoft.cryptoapp.common.Resource
import com.dlgsoft.cryptoapp.data.remote.dto.toCoinDetail
import com.dlgsoft.cryptoapp.domain.model.CoinDetail
import com.dlgsoft.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoin(coinId)
            emit(Resource.Success(coin.toCoinDetail()))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: ERROR_UNEXPECTED))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: ERROR_COULD_NOT_REACH_SERVER))
        }
    }
}