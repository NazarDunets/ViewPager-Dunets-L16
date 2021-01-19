package com.example.viewpager_dunets_l16

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class CountriesAdapter(activity: AppCompatActivity, private val items: List<Country>) :
    FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = items.size

    override fun createFragment(position: Int): Fragment {
        val c = items[position]
        return CountryFragment.newInstance(c.name, c.capital, c.population, c.area)
    }
}