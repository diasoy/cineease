package com.example.cineease.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SnackItem(
    val name: String,
    val description: String,
    val image: Int,
    val price: Int
) : Parcelable
