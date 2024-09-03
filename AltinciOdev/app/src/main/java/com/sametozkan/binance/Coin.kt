package com.sametozkan.binance

import androidx.compose.ui.graphics.ImageBitmap

data class Coin(
    val name: String,
    val abbreviation: String,
    val percentageChange: Double,
    val marketValue: Double,
    val icon: ImageBitmap
)