package ru.itis.homework2

data class Song(
    val id: Long,
    val name: String,
    val album: String,
    val artist: String,
    val photo: String,
    var isLiked: Boolean = false
)
