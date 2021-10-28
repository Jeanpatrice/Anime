package com.phatherjay.anime.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.phatherjay.anime.adapter.AnimeAdapter
import com.phatherjay.anime.databinding.FragmentAnimeListBinding
import com.phatherjay.anime.model.AnimeData
import com.phatherjay.anime.utils.ApiState
import com.phatherjay.anime.viewmodel.AnimeViewModel

open class AnimeListFragment : Fragment() {

    private var _binding: FragmentAnimeListBinding? = null
    private val binding get() = _binding!!
    private val animeViewModel by activityViewModels<AnimeViewModel>()
    private val animeAdapter by lazy { AnimeAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentAnimeListBinding.inflate(layoutInflater, container, false).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        setupObservers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initViews() = with(binding) {
        rvAnime.adapter = animeAdapter
    }

    private fun setupObservers() = with(animeViewModel) {
        animeState.observe(viewLifecycleOwner) { state ->
            binding.progressCircular.isVisible = state is ApiState.Loading
            if (state is ApiState.Success) loadAnimes(state.data)
            if (state is ApiState.Failure) handleFailure(state.errorMsg)
        }
    }

    private fun loadAnimes(anime: AnimeData) {
        anime.results?.let { animeAdapter.loadAnime(it) }
    }

    private fun handleFailure(errorMsg: String) {
        Log.d(TAG, "ApiState.Failure: $errorMsg")
    }

    companion object {
        private const val TAG = "AnimeListFragment"
    }
}