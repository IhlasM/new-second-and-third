package ru.itis.homework2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.itis.homework2.databinding.FragmentTextBinding

open class TextFragment : Fragment() {
    private var binding: FragmentTextBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTextBinding.bind(view)

        val text = arguments?.getString(ARG_TEXT) ?: "ERROR"

        binding?.run {
            textView.text = text
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTextBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ARG_TEXT = "ARG_TEXT"
        fun bundle(text: String): Bundle = Bundle().apply {
            putString(ARG_TEXT, text)
        }
    }
}