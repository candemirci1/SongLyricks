package com.example.songlyricks.ui.songlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.songlyricks.databinding.ItemSongBinding
import com.example.songlyricks.domain.Song

class SongListAdapter(
    private val songs: List<Song>,
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<SongListAdapter.SongViewHolder>() {

    class SongViewHolder(val binding: ItemSongBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val binding = ItemSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SongViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val currentSong = songs[position]
        holder.binding.apply {
            tvTitle.text = currentSong.name

            Glide.with(root.context)
                .load(currentSong.imageUrl)
                .into(ivSong)

            root.setOnClickListener {
                onClick.invoke(currentSong.url)

            }

        }
    }

    override fun getItemCount(): Int {
        return songs.size
    }

}