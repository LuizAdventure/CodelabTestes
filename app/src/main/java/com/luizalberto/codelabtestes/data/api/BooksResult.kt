package com.luizalberto.codelabtestes.data.api

import com.luizalberto.codelabtestes.model.Book

sealed class BooksResult {

    class Sucess(val books: List<Book>) : BooksResult()
    class ApiError(val statusCode: Int) : BooksResult()
    object ServerError : BooksResult()

}