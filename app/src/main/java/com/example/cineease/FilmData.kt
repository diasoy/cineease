package com.example.cineease

import Film
import android.content.Context
import com.example.cineease.R.drawable

class FilmData(context: Context) {
    private val filmNames = arrayOf(
        context.getString(R.string.film_name1),
        context.getString(R.string.film_name2),
        context.getString(R.string.film_name3),
        context.getString(R.string.film_name4),
        context.getString(R.string.film_name5)
    )
    private val filmDetails = arrayOf(
        context.getString(R.string.film_description1),
        context.getString(R.string.film_description2),
        context.getString(R.string.film_description3),
        context.getString(R.string.film_description4),
        context.getString(R.string.film_description5)
    )
    private val filmPosters = intArrayOf(
        drawable.ant_man,
        drawable.black_panther,
        drawable.captain_marvel,
        drawable.doctor_strange,
        drawable.end_game
    )
    val listData: ArrayList<Film>
        get() {
            val list = arrayListOf<Film>()
            for (position in filmNames.indices) {
                val film = Film(
                    judul = filmNames[position],
                    sinopsis = filmDetails[position],
                    poster = filmPosters[position]
                )
                list.add(film)
            }
            return list
        }
}