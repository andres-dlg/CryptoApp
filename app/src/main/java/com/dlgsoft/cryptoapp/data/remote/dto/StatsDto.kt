package com.dlgsoft.cryptoapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class StatsDto(
    @SerializedName("contributors")
    val contributors: Int,
    @SerializedName("followers")
    val followers: Int,
    @SerializedName("stars")
    val stars: Int,
    @SerializedName("subscribers")
    val subscribers: Int
)