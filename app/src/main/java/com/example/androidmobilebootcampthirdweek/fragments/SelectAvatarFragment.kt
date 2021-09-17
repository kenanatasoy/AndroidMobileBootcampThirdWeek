package com.example.androidmobilebootcampthirdweek.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmobilebootcampthirdweek.R
import com.example.androidmobilebootcampthirdweek.utils.AvatarModel
import com.example.androidmobilebootcampthirdweek.utils.SelectAvatarAdapter
import com.example.androidmobilebootcampthirdweek.utils.changeStatusBarColor
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_select_avatar.*


class SelectAvatarFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        changeStatusBarColor(R.color.select_avatar_background_color)
        
        val bottomNavigationView: BottomNavigationView = requireActivity().findViewById(R.id.bottomNavigationView)
        bottomNavigationView.visibility = View.GONE // here is the code for hiding the bottom navigation view in the fragment

        // do never hide the bottom navigation view this way or in this scope if it's the first fragment of the single activity,
        // it'll crash the app on launch because you require the activity while it's being created in that scenario
        // i've shown an optional way of doing that in the initially launched fragment(splash fragment in this case)
        // to simply hide the bottom navigation view, you can change the default value of visibility property to invisible in the xml

        return inflater.inflate(R.layout.fragment_select_avatar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var selectAvatarText = "Kullanıcı adınızı oluşturun ve size uygun bir avatar seçin"
        val avatarList = ArrayList<AvatarModel>()
        avatarList.add(AvatarModel(SelectAvatarAdapter.VIEW_FIRST, selectAvatarText, null))
        avatarList.add(AvatarModel(SelectAvatarAdapter.VIEW_SECOND, null, R.drawable.ic_avatar_01))
        avatarList.add(AvatarModel(SelectAvatarAdapter.VIEW_SECOND, null, R.drawable.ic_avatar_02))
        avatarList.add(AvatarModel(SelectAvatarAdapter.VIEW_SECOND, null, R.drawable.ic_avatar_03))
        avatarList.add(AvatarModel(SelectAvatarAdapter.VIEW_SECOND, null, R.drawable.ic_avatar_04))
        avatarList.add(AvatarModel(SelectAvatarAdapter.VIEW_SECOND, null, R.drawable.ic_avatar_05))
        avatarList.add(AvatarModel(SelectAvatarAdapter.VIEW_SECOND, null, R.drawable.ic_avatar_06))
        avatarList.add(AvatarModel(SelectAvatarAdapter.VIEW_SECOND, null, R.drawable.ic_avatar_07))
        avatarList.add(AvatarModel(SelectAvatarAdapter.VIEW_SECOND, null, R.drawable.ic_avatar_08))
        avatarList.add(AvatarModel(SelectAvatarAdapter.VIEW_SECOND, null, R.drawable.ic_avatar_09))
        avatarList.add(AvatarModel(SelectAvatarAdapter.VIEW_SECOND, null, R.drawable.ic_avatar_05))
        avatarList.add(AvatarModel(SelectAvatarAdapter.VIEW_SECOND, null, R.drawable.ic_avatar_07))
        avatarList.add(AvatarModel(SelectAvatarAdapter.VIEW_SECOND, null, R.drawable.ic_avatar_03))
        avatarList.add(AvatarModel(SelectAvatarAdapter.VIEW_SECOND, null, R.drawable.ic_avatar_04))
        avatarList.add(AvatarModel(SelectAvatarAdapter.VIEW_SECOND, null, R.drawable.ic_avatar_04))
        avatarList.add(AvatarModel(SelectAvatarAdapter.VIEW_SECOND, null, R.drawable.ic_avatar_08))
        avatarList.add(AvatarModel(SelectAvatarAdapter.VIEW_SECOND, null, R.drawable.ic_avatar_01))
        avatarList.add(AvatarModel(SelectAvatarAdapter.VIEW_SECOND, null, R.drawable.ic_avatar_06))
        avatarList.add(AvatarModel(SelectAvatarAdapter.VIEW_SECOND, null, R.drawable.ic_avatar_04))
        avatarList.add(AvatarModel(SelectAvatarAdapter.VIEW_SECOND, null, R.drawable.ic_avatar_05))
        avatarList.add(AvatarModel(SelectAvatarAdapter.VIEW_SECOND, null, R.drawable.ic_avatar_09))
        avatarList.add(AvatarModel(SelectAvatarAdapter.VIEW_SECOND, null, R.drawable.ic_avatar_08))
        avatarList.add(AvatarModel(SelectAvatarAdapter.VIEW_SECOND, null, R.drawable.ic_avatar_01))
        avatarList.add(AvatarModel(SelectAvatarAdapter.VIEW_SECOND, null, R.drawable.ic_avatar_06))
        avatarList.add(AvatarModel(SelectAvatarAdapter.VIEW_SECOND, null, R.drawable.ic_avatar_08))
        avatarList.add(AvatarModel(SelectAvatarAdapter.VIEW_SECOND, null, R.drawable.ic_avatar_04))

        // above is the completely static data to load the recycler view with

        val layoutManager = GridLayoutManager(activity, 3)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (position) {
                    0 -> 3 // here, we're basically saying that the element at index 0 should span 3 columns
                    else -> 1 // and the other ones should span one column for each
                }
            }
        }


        val selectAvatarAdapter = SelectAvatarAdapter(avatarList)

        recyclerView = selectAvatarList ?: RecyclerView(requireContext()) // here is the conditional assignation

        // of the packed data(array list above) to the recycler view

        recyclerView.layoutManager = layoutManager // assignation of the configured layout to the recycler view

        recyclerView.adapter = selectAvatarAdapter // assignation of recycler view's adapter to the recycler view


    }


}