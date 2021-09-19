package com.example.androidmobilebootcampthirdweek.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidmobilebootcampthirdweek.MainActivity
import com.example.androidmobilebootcampthirdweek.R
import com.example.androidmobilebootcampthirdweek.utils.changeStatusBarColor
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


/**
 * A simple [Fragment] subclass.
 * Use the [SplashFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class SplashFragment : Fragment() {

    private val ONSCREENSTAYDELAY  :  Long = 3 * 1000

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        changeStatusBarColor(R.color.white_tint)
        // in every fragment we call this method with different conditional color parameters
        // the goal is to make visual consistency between the status bar and the actual screen

        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment) // here is the utilization of a navigation action
        }, ONSCREENSTAYDELAY) // here we're delaying the operation for a specific time interval

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }



//    below is the optional way to hide BottomNavigationView from inside a fragment on launch

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        (requireActivity() as MainActivity).hideNavigation()
//
//    }


}