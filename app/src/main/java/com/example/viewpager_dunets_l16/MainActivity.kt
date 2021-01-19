package com.example.viewpager_dunets_l16

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewpager_dunets_l16.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
    }

    override fun onStart() {
        super.onStart()

        val countries = CountryData.countries
        binding.viewPager.adapter = CountriesAdapter(this, countries)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) {tab, position ->
            tab.text = countries[position].name
        }.attach()
    }

    private fun setupBinding() {
       binding = ActivityMainBinding.inflate(layoutInflater)
       setContentView(binding.root)
    }
}