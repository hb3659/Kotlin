package com.example.minimelon

import java.io.Serializable

class Song(
    val title: String? = null,
    val thumbnail: String? = null,
    val song: String? = null
) : Serializable