package com.example.myapplicationml.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationml.R
import com.example.myapplicationml.ui.avis.AvisViewModel


class AvisAdapter(private val mList: List<AvisViewModel>) : RecyclerView.Adapter<AvisAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_avis, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        //holder.imageView.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.avis.text = ItemsViewModel.avis
        holder.client.text = ItemsViewModel.client
        holder.rating.rating = ItemsViewModel.rating

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        //val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val rating = itemView.findViewById<RatingBar>(R.id.ratingBar)
        val client: TextView = itemView.findViewById(R.id.client)
        val avis: TextView = itemView.findViewById(R.id.text_avis)
    }
}
