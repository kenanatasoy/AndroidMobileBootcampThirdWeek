package com.example.androidmobilebootcampthirdweek.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.example.androidmobilebootcampthirdweek.MainActivity
import com.example.androidmobilebootcampthirdweek.R
import com.example.androidmobilebootcampthirdweek.utils.changeStatusBarColor
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        changeStatusBarColor(R.color.yellow)

        val bottomNavigationView: BottomNavigationView = requireActivity().findViewById(R.id.bottomNavigationView)
        bottomNavigationView.visibility = View.VISIBLE

        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileEditButton.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_selectAvatarFragment)
            // here is another utilization of one of navigation architecture component's actions
        }
    }

    override fun onResume() {
        super.onResume()

        // in this block what we're simply doing is that we show a dialog
        // when the user presses the back button when in this fragment

        val activity = activity as MainActivity

        activity.onBackPressedDispatcher.addCallback(viewLifecycleOwner, object :
            OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                AlertDialog.Builder(requireContext())
                    .setTitle("Çıkış")
                    .setMessage("Çıkmak istediğinize emin misiniz?")
                    .setCancelable(false)
                    .setNegativeButton("Evet") { _, _ ->
                        activity.finish()
                    }
                    .setPositiveButton("Hayır") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
            }
        })

    }

}