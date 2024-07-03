package ru.itis.homework2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import ru.itis.homework2.R
import ru.itis.homework2.databinding.FragmentHomeBinding

open class HomeFragment : Fragment() {
    private var binding: FragmentHomeBinding? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        binding.apply {
            val button = binding?.sendButton
            button?.setOnClickListener {
                val text = binding?.inputText?.text.toString()
                if (text.isBlank()) {
                    Snackbar.make(view, "Поле не должно быть пустым", Snackbar.LENGTH_LONG).show()
                } else {
                    findNavController().navigate(
                        R.id.action_homeFragment_to_textFragment,
                        TextFragment.bundle(text)
                    )
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}