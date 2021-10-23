package com.dlgsoft.cryptoapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class WhitepaperDto(
    @SerializedName("link")
    val link: String,
    @SerializedName("thumbnail")
    val thumbnail: String
)