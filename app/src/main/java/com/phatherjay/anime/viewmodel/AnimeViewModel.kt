package com.phatherjay.anime.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phatherjay.anime.model.AnimeData
import com.phatherjay.anime.network.AnimeRepo
import com.phatherjay.anime.utils.ApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnimeViewModel: ViewModel() {
    private val _animeState = MutableLiveData<ApiState<AnimeData>>(ApiState.Loading)
    val animeState: LiveData<ApiState<AnimeData>>
        get() = _animeState

    fun fetchCharacter(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            AnimeRepo.fetchAnime(query).let { response ->
                val state = if (response.isSuccessful || response.body() != null) {
                    ApiState.Success(response.body()!!)
                }else ApiState.Failure("Anime body is null")
                _animeState.postValue(state)
            }
        }
    }
}