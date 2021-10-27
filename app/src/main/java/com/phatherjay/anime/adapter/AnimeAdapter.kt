package com.phatherjay.anime.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.phatherjay.anime.databinding.ItemAnimeBinding
import com.phatherjay.anime.model.Result
import com.phatherjay.anime.utils.loadWithGlide

class AnimeAdapter(
    private val animeListener: (Result) -> Unit
): RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    private val animeList: MutableList<Result> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= AnimeViewHolder.getInstance(parent).also { anime ->
        anime.itemView.setOnClickListener { animeListener(animeList[anime.adapterPosition]) }
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.loadCharacter(animeList[position])
    }

    override fun getItemCount() = animeList.size

    fun loadAnime(anime: List<Result>){
        val startPosition = anime.size
        animeList.addAll(anime)
        notifyItemRangeInserted(startPosition, anime.size)
    }

    fun clear() {
        val listSize = animeList.size
        animeList.clear()
        notifyItemRangeRemoved(0, listSize)
    }

    class AnimeViewHolder(
        private val binding: ItemAnimeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun loadCharacter(anime: Result) = with(binding) {
            val img =  anime.imageUrl
            tvName.text = anime.title
            ivAnimeImage.loadWithGlide(img)
        }


        companion object {
            fun getInstance(parent: ViewGroup): AnimeViewHolder {
                val binding =
                    ItemAnimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return AnimeViewHolder(binding)
            }
        }
    }
}