package ru.itis.homework2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.squareup.picasso.Picasso
import ru.itis.homework2.R
import ru.itis.homework2.databinding.ItemSongDetailBinding

class DetailSongFragment : Fragment() {
    private var binding: ItemSongDetailBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ItemSongDetailBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ItemSongDetailBinding.bind(view)
        val songName = arguments?.getString(ARG_SONG_NAME) ?: "ERROR"
        val artistName = arguments?.getString(ARG_ARTIST_NAME) ?: "ERROR"
        val albumName = arguments?.getString(ARG_ALBUM_NAME) ?: "ERROR"
        val imageUrl = arguments?.getString(ARG_IMAGE_URL) ?: "ERROR"
        binding?.run {
            detailSongTitle.text = songName
            detailArtistTitle.text = artistName
            detailAlbumName.text = albumName
            Picasso.get().load(imageUrl).into(detailSongImage)

        }
        val button = binding?.tobackButton
        button?.setOnClickListener {
            findNavController().navigate(R.id.musicFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ARG_SONG_NAME = "SONG"
        private const val ARG_ARTIST_NAME = "ARTIST"
        private const val ARG_ALBUM_NAME = "ALBUM"
        private const val ARG_IMAGE_URL = "IMAGE"
        fun bundle(
            songName: String,
            artistName: String,
            albumName: String,
            imageUrl: String
        ): Bundle = Bundle().apply {
            putString(ARG_SONG_NAME, songName)
            putString(ARG_ARTIST_NAME, artistName)
            putString(ARG_ALBUM_NAME, albumName)
            putString(ARG_IMAGE_URL, imageUrl)
        }
    }
}
