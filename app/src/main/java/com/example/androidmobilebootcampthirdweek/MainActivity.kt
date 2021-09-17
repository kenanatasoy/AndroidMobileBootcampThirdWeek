package com.example.androidmobilebootcampthirdweek

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.androidmobilebootcampthirdweek.utils.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navController = findNavController(R.id.fragment_container)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
        // Bottom navigation view's implementation with the navigation architecture component

    }


    // below is the optional useful functions for hiding and showing bottom navigation view on specific delay

    fun hideNavigation() {
        bottomNavigationView.postDelayed(
            {
                bottomNavigationView.gone()

            }, 0
        )
    }

    fun showNavigation() {
        bottomNavigationView.postDelayed(
            {
                bottomNavigationView.visible()

            }, 0
        )
    }


}