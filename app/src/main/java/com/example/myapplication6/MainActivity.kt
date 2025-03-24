package com.example.myapplication6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val countryList: MutableList<Country> = ArrayList()
        countryList.add(Country("Vietnam", "98,000,000", R.drawable.vietnam_flag))
        countryList.add(Country("United States", "320,000,000", R.drawable.usa_flag))
        countryList.add(Country("Russia", "142,000,000", R.drawable.russia_flag))
        countryList.add(Country("Kazakhstan", "21000000", R.drawable.kazakhstan_flag))
        countryList.add(Country("Czech", "10000000", R.drawable.czech))

        val CountryAdapter: CountryAdapter = CountryAdapter(countryList)

        recyclerView.adapter = CountryAdapter
    }
}