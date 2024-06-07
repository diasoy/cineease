package com.example.cineease

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cineease.adapter.DrinkAdapter
import com.example.cineease.adapter.SnackAdapter
import com.example.cineease.data.Drink
import com.example.cineease.data.Snack
import com.google.android.material.bottomnavigation.BottomNavigationView

class SnackActivity : AppCompatActivity() {

    private lateinit var rvSnack: RecyclerView
    private lateinit var rvDrink: RecyclerView
    private var listSnack: ArrayList<Snack> = arrayListOf()
    private var listDrink: ArrayList<Drink> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snack)

        rvSnack = findViewById(R.id.rv_snack)
        rvSnack.setHasFixedSize(true)

        rvDrink = findViewById(R.id.rv_drink)
        rvDrink.setHasFixedSize(true)

        try {
            listSnack.addAll(getListSnacks())
            listDrink.addAll(getListDrinks())
        } catch (e: Exception) {
            e.printStackTrace()
            // Show a user-friendly message or handle the error gracefully
        }

        showRecyclerList()

        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        navView.selectedItemId = R.id.navigation_snack

        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_snack -> {
                    // Do nothing, we're already here
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

    private fun getListSnacks(): ArrayList<Snack> {
        val dataName = resources.getStringArray(R.array.data_name_snack)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo_snack)
        val dataPrice = resources.getStringArray(R.array.data_price_snack)

        val listSnack = ArrayList<Snack>()
        for (position in dataName.indices) {
            val snack = Snack(
                name = dataName[position],
                image = dataPhoto.getResourceId(position, -1),
                price = dataPrice[position]
            )
            listSnack.add(snack)
        }
        dataPhoto.recycle()  // Recycle the typed array
        return listSnack
    }

    private fun getListDrinks(): ArrayList<Drink> {
        val dataName = resources.getStringArray(R.array.data_name_drink)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo_drink)
        val dataPrice = resources.getStringArray(R.array.data_price_drink)

        val listDrink = ArrayList<Drink>()
        for (position in dataName.indices) {
            val drink = Drink(
                name = dataName[position],
                image = dataPhoto.getResourceId(position, -1),
                price = dataPrice[position]
            )
            listDrink.add(drink)
        }
        dataPhoto.recycle()  // Recycle the typed array
        return listDrink
    }

    private fun showRecyclerList() {
        rvSnack.layoutManager = LinearLayoutManager(this)
        val snackAdapter = SnackAdapter(listSnack)
        rvSnack.adapter = snackAdapter

        rvDrink.layoutManager = LinearLayoutManager(this)
        val drinkAdapter = DrinkAdapter(listDrink)
        rvDrink.adapter = drinkAdapter
    }
}
