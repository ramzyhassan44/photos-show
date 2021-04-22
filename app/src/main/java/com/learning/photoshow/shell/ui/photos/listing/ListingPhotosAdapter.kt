package com.learning.photoshow.shell.ui.photos.listing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.learning.photoshow.core.data.SinglePhoto
import com.learning.photoshow.databinding.RecyclerPhotoRowBinding

class ListingPhotosAdapter(
    var photos: List<SinglePhoto>,
    val onItemClicked: (position: Int) -> Unit
) :
    RecyclerView.Adapter<ListingPhotosAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: RecyclerPhotoRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecyclerPhotoRowBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            binding.photoName.text = photos[position].name
            binding.creationTime.text = photos[position].creationTime
            itemView.setOnClickListener { onItemClicked(position) }
        }
    }

    override fun getItemCount(): Int {
        return photos.size
    }
}

