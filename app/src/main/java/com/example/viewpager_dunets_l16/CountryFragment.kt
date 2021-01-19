package com.example.viewpager_dunets_l16

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.viewpager_dunets_l16.databinding.CountryFragmentBinding

private const val ARG_NAME = "countryName"
private const val ARG_CAPITAL = "countryCapital"
private const val ARG_POPULATION = "countryPopulation"
private const val ARG_AREA = "countryArea"

class CountryFragment : Fragment() {

    private var _binding: CountryFragmentBinding? = null
    private val binding get() = requireNotNull(_binding)

    private var cName: String = "Name"
    private var cCapital: String = "Capital"
    private var cPopulation: Int = 0
    private var cArea: Double = 0.0
    private val cDensity: Double get() = cPopulation / cArea

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cName = it.getString(ARG_NAME, "Name")
            cCapital = it.getString(ARG_CAPITAL, "Capital")
            cPopulation = it.getInt(ARG_POPULATION, 0)
            cArea = it.getDouble(ARG_AREA, 0.0)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CountryFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvName.text = getString(R.string.country_name, cName)
        binding.tvCapital.text = getString(R.string.country_capital, cCapital)
        binding.tvPopulation.text = getString(R.string.country_population, cPopulation)
        binding.tvArea.text = getString(R.string.country_area, cArea)
        binding.tvDensity.text = getString(R.string.country_density, cDensity)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(name: String, capital: String, population: Int, area: Double) =
            CountryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_NAME, name)
                    putString(ARG_CAPITAL, capital)
                    putInt(ARG_POPULATION, population)
                    putDouble(ARG_AREA, area)
                }
            }
    }
}