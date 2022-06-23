package ru.netology.nmedia

data class Post(
    val avatar: Int, //temporary take from resources
    val author: String = "",
    val date: String = "",
    val text: String = "",
    var likes: Int = 0,
    var shares: Int = 0,
    var views: Int = 0,
    var likedByMe: Boolean = false
)

fun getLoremPost(): Post = Post(
    R.drawable.ic_launcher_foreground,
    "Olga Larina",
    "20 мая 2022 г.",
    "Это простое тестовое сообщение, которое ничего не значит, но очень нужно для тестирования функционала при разработке",
    999,
    999_999,
    3_200_566,
    false
)
