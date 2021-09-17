package com.example.androidmobilebootcampthirdweek.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmobilebootcampthirdweek.R
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView

class SelectAvatarAdapter(val avatarList : ArrayList<AvatarModel>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // above is the definition of the recycler view's adapter which extends RecyclerView.Adapter class
    // it takes the data that'll be displayed in the recycler view


    var selectedItemPosition = -1 // here are the flag variables which we'll use later on in this code
    var lastItemSelectedPosition = -1

    companion object{
        const val VIEW_FIRST = 1
        const val VIEW_SECOND = 2 // item types' declaration
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        // here we are creating and returning the view holders of the view's that'll be repeated throughout the recycler view

        return if (viewType == VIEW_FIRST){
            ViewHolderText(LayoutInflater.from(parent.context).inflate(R.layout.item_text, parent,false))
        } else{
            ViewHolderImage(LayoutInflater.from(parent.context).inflate(R.layout.item_avatar, parent,false))
        }

    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        // here we're binding views to data model we created earlier

        if (avatarList[position].viewType == VIEW_FIRST && holder is ViewHolderText){
            holder.bind(position)
        }

        else{
            (holder as ViewHolderImage).bind(position)
            if(position == selectedItemPosition)
                holder.checkboxChecked()
            else
                holder.checkboxUnchecked()
        }

    }



    override fun getItemViewType(position: Int): Int{
        return avatarList[position].viewType
    }



    override fun getItemCount(): Int {
        return avatarList.size
    }



    inner class ViewHolderImage(itemView : View) : RecyclerView.ViewHolder(itemView){

        // here is the first view holder inner class which extends RecyclerView.ViewHolder
        // here we're binding associating & binding
        // inner variables with views that'll be repeated throughout the recycler view

        private val imageView: ImageView = itemView.findViewById(R.id.selectAvatar)

        fun bind(position: Int){

            val recyclerViewModel = avatarList[position]
            imageView.setImageResource(recyclerViewModel.resourceId!!)

        }

        private val checkBox: ImageView = itemView.findViewById(R.id.checkBox)

        // configuration of checkbox state

        fun checkboxChecked() {
            checkBox.setImageResource(R.drawable.ic_circle_checkbox_outline_checked)
        }

        fun checkboxUnchecked() {
            checkBox.setImageResource(R.drawable.ic_circle_checkbox_unchecked)
        }


        init {
            itemView.setOnClickListener { // here is the logic for selecting unselected items and deselecting selected items
                selectedItemPosition = adapterPosition
                if(lastItemSelectedPosition == -1)
                    lastItemSelectedPosition = selectedItemPosition
                else {
                    notifyItemChanged(lastItemSelectedPosition)
                    lastItemSelectedPosition = selectedItemPosition
                }
                notifyItemChanged(selectedItemPosition)
            }
        }

    }




    inner class ViewHolderText(itemView : View) : RecyclerView.ViewHolder(itemView){

        // here is the second view holder inner class for the other item that'll go in the recycler
        // and below is the association and binding of the private textView item to the corresponding UI element

        private val textView: AppCompatTextView = itemView.findViewById(R.id.selectAvatarText)

        fun bind(position: Int){
            val recyclerViewModel = avatarList[position]
            textView.text = recyclerViewModel.text
        }
    }
}