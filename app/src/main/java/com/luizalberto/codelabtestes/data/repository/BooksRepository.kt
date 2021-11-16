package com.luizalberto.codelabtestes.data.repository

import com.luizalberto.codelabtestes.data.api.BooksResult

interface BooksRepository {

    fun getBooks(booksResultCallback: (result: BooksResult) -> Unit)

}