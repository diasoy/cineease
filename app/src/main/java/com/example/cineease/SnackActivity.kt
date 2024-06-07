package com.example.cineease

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cineease.adapter.ListSnackAdapter
import com.example.cineease.data.SnackItem

class SnackActivity : AppCompatActivity() {
    private lateinit var rvSnacks: RecyclerView
    private var list: ArrayList<SnackItem> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snack)

        rvSnacks = findViewById(R.id.rv_snacks)

        rvSnacks.setHasFixedSize(true)

        list.addAll(getListSnacks())
        showRecyclerList()
    }

    private fun getListSnacks(): ArrayList<SnackItem> {
        return arrayListOf(
            SnackItem("Bucket Popcorn", "Delicious butter popcorn", R.drawable.bucket_popcorn, 10000),
            SnackItem("Box Popcorn", "Crispy nachos with cheese", R.drawable.box_popcorn, 7000),
            SnackItem("Ice Chocolate", "Refreshing chocolate drink", R.drawable.ice_chocolate, 5000),
            SnackItem("Soda", "Refreshing soda drink", R.drawable.coca_cola, 5000)
        )
    }

    private fun showRecyclerList() {
        rvSnacks.layoutManager = LinearLayoutManager(this)
        val listSnackAdapter = ListSnackAdapter(list)
        rvSnacks.adapter = listSnackAdapter

        listSnackAdapter.setOnItemClickCallback(object : ListSnackAdapter.OnItemClickCallback {
            override fun onItemClicked(data: SnackItem) {
                val intent = Intent(this@SnackActivity, DetailSnackActivity::class.java)
                intent.putExtra(DetailSnackActivity.EXTRA_SNACK, data)
                startActivity(intent)
            }
        })
    }
}
