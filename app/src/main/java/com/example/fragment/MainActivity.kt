package com.example.fragment

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fragment.databinding.ActivityMainBinding
import com.example.fragment.modele.DataViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var viewModel : DataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonF1.setOnClickListener {
            remplaceFragment(binding.fragmentContainerView, Fragment1())
        }

        binding.buttonF2.setOnClickListener {
            remplaceFragment(binding.fragmentContainerView, Fragment2())
        }
        viewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        binding.lifecycleOwner = this@MainActivity
        viewModel.dataForBinding.observe(this) {
            compteur -> Log.d("MainActivity", "Compteur: $compteur")
        }
        }

    private fun remplaceFragment(fragmentContainerView: FragmentContainerView, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
        .replace(fragment.id, fragment)
        .commit()
    }
    }
