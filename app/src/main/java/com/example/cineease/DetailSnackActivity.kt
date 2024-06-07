package com.example.cineease

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatSpinner
import com.example.cineease.data.SnackItem

class DetailSnackActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_SNACK = "extra_snack"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_snack)

        val imgSnack: ImageView = findViewById(R.id.img_snack)
        val tvName: TextView = findViewById(R.id.tv_name)
        val tvDescription: TextView = findViewById(R.id.tv_description)
        val tvPrice: TextView = findViewById(R.id.tv_price)
        val spinnerQuantity: AppCompatSpinner = findViewById(R.id.spinner_quantity)
        val btnBuy: Button = findViewById(R.id.btn_buy)

        val snack = intent.getParcelableExtra<SnackItem>(EXTRA_SNACK)

        imgSnack.setImageResource(snack?.image ?: 0)
        tvName.text = snack?.name
        tvDescription.text = snack?.description
        tvPrice.text = getString(R.string.price_format, snack?.price)

        btnBuy.setOnClickListener {
            val quantity = spinnerQuantity.selectedItem.toString().toInt()
            val total = snack?.price?.times(quantity)
            AlertDialog.Builder(this).apply {
                setTitle("Confirm Purchase")
                setMessage("Total price: $total. Do you want to proceed?")
                setPositiveButton("Yes") { _, _ ->
                    Toast.makeText(this@DetailSnackActivity, "Purchase successful!", Toast.LENGTH_SHORT).show()
                }
                setNegativeButton("No", null)
            }.create().show()
        }
    }
}
