package com.luizalberto.codelabtestes.data.response

import com.luizalberto.codelabtestes.model.Book
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BookDetailsResponse (
    @Json(name = "title")
    val title: String,
    @Json(name = "author")
    val author: String,
    @Json(name = "description")
    val description: String
) {
    fun getBookModel() = Book(
        this.title,
        this.author,
        this.description
    )
}