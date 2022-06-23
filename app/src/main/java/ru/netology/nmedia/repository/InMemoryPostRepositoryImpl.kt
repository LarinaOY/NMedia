package ru.netology.nmedia.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.Post
import ru.netology.nmedia.R

class InMemoryPostRepositoryImpl : PostRepository {

    private val loremPost = Post(
        R.drawable.ic_launcher_foreground,
        "Olga Larina",
        "20 мая 2022 г.",
        "Это простое тестовое сообщение, которое ничего не значит, но очень нужно для тестирования функционала при разработке",
        999,
        999_999,
        3_200_566,
        false
    )

    val data = MutableLiveData(loremPost)

    override fun get(): LiveData<Post> = data

    override fun like() {

        data.value?.let { post ->
            if (post.likedByMe) {
                val newPost = post.copy(likedByMe = false, likes = post.likes - 1)
                data.value = newPost
            } else {
                val newPost = post.copy(likedByMe = true, likes = post.likes + 1)
                data.value = newPost
            }
        }
    }

    override fun share() {
        data.value?.let { post ->
            val newPost = post.copy(shares = post.shares + 1)
            data.value = newPost
        }
    }

    override fun view() {
        data.value?.let { post ->
            val newPost = post.copy(views = post.views + 1)
            data.value = newPost
        }
    }
}