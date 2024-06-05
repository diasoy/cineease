package com.example.cineease

import Film
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.cineease.adapter.BannerAdapter
import com.example.cineease.style.SpaceItemDecoration
import com.google.android.material.bottomnavigation.BottomNavigationView
import me.relex.circleindicator.CircleIndicator3

class MainActivity : AppCompatActivity() {
    private lateinit var rvFilm: RecyclerView
    private var list: ArrayList<Film> = arrayListOf()


    private lateinit var viewPager: ViewPager2
    private lateinit var indicator: CircleIndicator3
    private lateinit var bannerAdapter: BannerAdapter
    private val banners = listOf(R.drawable.banner1, R.drawable.banner2, R.drawable.banner3)
    private val handler = Handler(Looper.getMainLooper())
    private val runnable = Runnable {
        var pos = viewPager.currentItem
        if (pos == banners.size - 1) pos = 0
        else pos++
        viewPager.setCurrentItem(pos, true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFilm = findViewById(R.id.rv_film)
        rvFilm.addItemDecoration(SpaceItemDecoration(160)) // Now rvFilm has been initialized

        viewPager = findViewById(R.id.viewPager)
        indicator = findViewById(R.id.indicator)

        bannerAdapter = BannerAdapter(banners)
        viewPager.adapter = bannerAdapter
        indicator.setViewPager(viewPager)

        handler.postDelayed(runnable, 3000)

        rvFilm.setHasFixedSize(true)

        val filmData = FilmData(this)
        list.addAll(filmData.listData)
        showRecyclerList()

        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    true
                }
                R.id.navigation_snack -> {
                    val intent = Intent(this, SnackActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_order -> {
                    val intent = Intent(this, OrderActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    private fun showRecyclerList() {
        rvFilm.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val listFilmAdapter = ListFilmAdapter(list)
        rvFilm.adapter = listFilmAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
    }
}