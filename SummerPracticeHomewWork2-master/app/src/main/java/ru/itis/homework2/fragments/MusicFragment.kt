package ru.itis.homework2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.itis.homework2.R
import ru.itis.homework2.SongAdapter
import ru.itis.homework2.databinding.FragmentMusicBinding

open class MusicFragment : Fragment() {
    private var binding: FragmentMusicBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMusicBinding.bind(view)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_music, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.music_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = SongAdapter()
        recyclerView.adapter = adapter
        binding = FragmentMusicBinding.inflate(inflater, container, false)
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}