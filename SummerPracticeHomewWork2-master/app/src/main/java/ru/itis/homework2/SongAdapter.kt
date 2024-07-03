package ru.itis.homework2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import ru.itis.homework2.fragments.DetailSongFragment
import kotlin.random.Random

open class SongAdapter : RecyclerView.Adapter<SongAdapter.SongViewHolder>() {
    private val songs: MutableList<Song> = mutableListOf(
        Song(
            Random.nextLong(),
            "R.I.P",
            "Die Lit",
            "Playboi Carti",
            "https://acclaimmag.com/wp-content/uploads/2018/05/playboi-carti-die-lit-feauture-image.jpg",
            false
        ),
        Song(
            Random.nextLong(),
            "Tell My Haters",
            "Life of Dark Rose",
            "Lil Skies",
            "https://avatars.yandex.net/get-music-content/49707/d5bc6433.a.4927582-1/200x200",
            false
        ),
        Song(
            Random.nextLong(),
            "Dead Broke",
            "Unbothered",
            "Lil Skies",
            "https://avatars.yandex.net/get-music-content/4384958/eb62a356.a.15582412-1/200x200",
            false
        ),
        Song(
            Random.nextLong(),
            "YSL & ERD",
            "OMG SEASON",
            "ROCKET",
            "https://t2.genius.com/unsafe/1249x0/https%3A%2F%2Fimages.genius.com%2Fc17b70f4d784d8cefb9dbd14115a7a8d.1000x1000x1.png",
            false
        ),
        Song(
            Random.nextLong(),
            "Old Money",
            "Die Lit",
            "Playboi Carti",
            "https://acclaimmag.com/wp-content/uploads/2018/05/playboi-carti-die-lit-feauture-image.jpg",
            false
        ),
        Song(
            Random.nextLong(),
            "Lust",
            "Life of Dark Rose",
            "Lil Skies",
            "https://avatars.yandex.net/get-music-content/49707/d5bc6433.a.4927582-1/200x200",
            false
        ),
        Song(
            Random.nextLong(),
            "SLOW MOTION",
            "OMG SEASON",
            "ROCKET",
            "https://t2.genius.com/unsafe/1249x0/https%3A%2F%2Fimages.genius.com%2Fc17b70f4d784d8cefb9dbd14115a7a8d.1000x1000x1.png",
            false
        )
    ).toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongAdapter.SongViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongAdapter.SongViewHolder, position: Int) {
        val currentSong = songs[position]
        holder.songTitle.text = currentSong.name
        holder.artistTitle.text = currentSong.artist
        Picasso.get().load(currentSong.photo).into(holder.songImage)
        holder.itemView.setOnClickListener {
            holder.itemView.findNavController().navigate(
                resId = R.id.action_musicFragment_to_detailSongFragment,
                args = DetailSongFragment.bundle(
                    currentSong.name,
                    currentSong.artist,
                    currentSong.album,
                    currentSong.photo
                )
            )
        }
        holder.likeButton.setOnClickListener {
            if (currentSong.isLiked) {
                Snackbar.make(holder.itemView, "Больше не нравится", Snackbar.LENGTH_LONG).show()
                holder.likeButton.setImageResource(R.drawable.like_logo)
                currentSong.isLiked = false
            } else {
                Snackbar.make(holder.itemView, "Добавлено в понравившиеся", Snackbar.LENGTH_LONG)
                    .show()
                holder.likeButton.setImageResource(R.drawable.like_logo_red)
                currentSong.isLiked = true
            }

        }
    }

    override fun getItemCount(): Int {
        return songs.size
    }

    inner class SongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val songTitle: TextView = itemView.findViewById(R.id.song_title)
        val artistTitle: TextView = itemView.findViewById(R.id.artist_title)
        val songImage: ImageView = itemView.findViewById(R.id.song_image)
        val likeButton: ImageButton = itemView.findViewById(R.id.like_image)

    }

    open fun getSongs() = songs


}