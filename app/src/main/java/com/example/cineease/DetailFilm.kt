package com.example.cineease

import Film
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailFilm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_film)

        val tvTitle: TextView = findViewById(R.id.tv_title)
        val tvSynopsis: TextView = findViewById(R.id.tv_synopsis)
        val imgPoster: ImageView = findViewById(R.id.img_poster)

        val film = intent.getParcelableExtra<Film>("EXTRA_FILM")

        tvTitle.text = film?.judul
        tvSynopsis.text = film?.sinopsis
        imgPoster.setImageResource(film?.poster ?: 0)
    }
}