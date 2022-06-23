package ru.netology.nmedia

import androidx.lifecycle.ViewModel
import ru.netology.nmedia.repository.InMemoryPostRepositoryImpl

class MainActivityViewModel: ViewModel() {

    private val repository = InMemoryPostRepositoryImpl()

    val data by repository::data

    fun onLikeClicked() = repository.like()
    fun onShareButtonClicked() = repository.share()
    fun onViewButtonClicked() = repository.view()

}