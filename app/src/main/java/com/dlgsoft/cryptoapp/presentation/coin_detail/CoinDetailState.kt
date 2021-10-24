package com.dlgsoft.cryptoapp.presentation.coin_detail

import com.dlgsoft.cryptoapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)