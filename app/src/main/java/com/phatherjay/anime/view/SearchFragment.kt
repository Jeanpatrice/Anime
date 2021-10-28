package com.phatherjay.anime.view

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.phatherjay.anime.databinding.FragmentSearchBinding
import com.phatherjay.anime.viewmodel.AnimeViewModel

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val animeVM by activityViewModels<AnimeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentSearchBinding.inflate(layoutInflater, container, false).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initView() = with(binding) {
        //when Enter key is pressed it acts as if the submit button was pressed

        actvName.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            return@OnKeyListener if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
                updateQuery()
                true
            } else false
        })
        btnSubmit.setOnClickListener { updateQuery() }
    }


    private fun updateQuery() {
        val queryString = binding.actvName.text.toString()
        if (queryString.isNotBlank()) {
            animeVM.fetchCharacter(queryString)
            SearchFragmentDirections.actionSettingsFragmentToAnimeListFragment().also {
                findNavController().navigate(it)
            }
        } else {
            Toast.makeText(context, " Enter Anime Title Name ", Toast.LENGTH_LONG).show()
        }
    }
}