package com.example.gameplateformtask

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.gameplateformtask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        // Setup the BottomNavigationView with NavController
        binding.navbarView.setupWithNavController(navController)

        // Add listener to show/hide BottomNavigationView based on the current fragment
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.home_screen -> binding.navbarView.visibility = View.VISIBLE
                else -> binding.navbarView.visibility = View.GONE
            }
        }

        // Set the listener for BottomNavigationView items
        binding.navbarView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home_screen -> navController.navigate(R.id.home_screen)
            }
            true
        }

    }
}