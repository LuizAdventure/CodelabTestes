package com.luizalberto.codelabtestes.data.repository

import com.luizalberto.codelabtestes.data.BooksResult

interface BooksRepository {

    fun getBooks(booksResultCallback: (result: BooksResult) -> Unit)

}