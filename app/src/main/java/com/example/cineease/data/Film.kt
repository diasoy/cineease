package com.example.cineease.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(
    var judul: String,
    var sinopsis: String,
    var poster: Int
) : Parcelable