package com.luizalberto.codelabtestes.data

import com.luizalberto.codelabtestes.data.model.Book

sealed class BooksResult {

    class Sucess(val books: List<Book>) : BooksResult()
    class ApiError(val statusCode: Int) : BooksResult()
    object ServerError : BooksResult()

}