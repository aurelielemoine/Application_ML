package com.example.myapplicationml.ui.gallery

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationml.R
import com.example.myapplicationml.ui.AvisAdapter


class GalleryAdapter(
    val arrayGallery: ArrayList<GalleryViewModel>,
    private val onItemClicked: (GalleryViewModel, Int) -> Unit // Callback : (item cliqué, position)
) : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_image, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = arrayGallery[position]
        holder.image.setImageResource(currentItem.image)

        holder.itemView.setOnClickListener {
            onItemClicked(currentItem, position)
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return arrayGallery.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val image: ImageView = itemView.findViewById(R.id.imageView2)
    }
}
