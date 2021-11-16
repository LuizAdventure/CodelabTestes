package com.luizalberto.codelabtestes.ui.books

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.luizalberto.codelabtestes.R
import com.luizalberto.codelabtestes.data.BooksResult
import com.luizalberto.codelabtestes.data.model.Book
import com.luizalberto.codelabtestes.data.repository.BooksRepository
import com.nhaarman.mockitokotlin2.verify
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class BooksViewModelTest{

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var booksLiveDataObserver: Observer<List<Book>>

    @Mock
    private lateinit var viewFlipperLiveDataObserver: Observer<Pair<Int, Int?>>

    private lateinit var viewModel: BooksViewModel

    @Test
    fun `getBooks get sucess then sets bookLiveData`(){
        val books = listOf(
            Book("1","1","1")
        )

        val resultSucess = MockRepository(BooksResult.Sucess(books))
        viewModel = BooksViewModel(resultSucess)
        viewModel.booksLiveData.observeForever(booksLiveDataObserver)
        viewModel.viewFlipperLiveData.observeForever(viewFlipperLiveDataObserver)


        viewModel.getBooks()


        verify(booksLiveDataObserver).onChanged(books)
        verify(viewFlipperLiveDataObserver).onChanged(Pair(1,null))


    }

    @Test
    fun `getBooks get error then sets viewFlipperLiveData`(){
        val resultServerError = MockRepository(BooksResult.ServerError)
        viewModel = BooksViewModel(resultServerError)
        viewModel.viewFlipperLiveData.observeForever(viewFlipperLiveDataObserver)

        viewModel.getBooks()

        verify(viewFlipperLiveDataObserver).onChanged(Pair(2, R.string.error_500_generic))


    }



}

class MockRepository(private val result: BooksResult): BooksRepository{

    override fun getBooks(booksResultCallback: (result: BooksResult) -> Unit) {
        booksResultCallback(result)
          }
}