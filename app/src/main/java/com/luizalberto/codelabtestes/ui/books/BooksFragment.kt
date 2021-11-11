package com.luizalberto.codelabtestes.ui.books

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.luizalberto.codelabtestes.R
import com.luizalberto.codelabtestes.data.repository.BooksApiDataSource
import kotlinx.android.synthetic.main.books_fragment.*

class BooksFragment : Fragment() {

    companion object {
        fun newInstance() = BooksFragment()
    }

    val viewModel: BooksViewModel = BooksViewModel.ViewModelFactory(BooksApiDataSource())
        .create(BooksViewModel::class.java)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.books_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.booksLiveData.observe(viewLifecycleOwner, Observer {
            it?.let { books ->
                with(recycler_view_books) {
                    layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = BooksAdapter(books)
                }
            }
        })

        viewModel.viewFlipperLiveData.observe(viewLifecycleOwner, Observer { viewFlipper ->
            viewFlipperBooks.displayedChild = viewFlipper.first

            viewFlipper.second?.let { errorMessengerResId ->
                error.text = getString(errorMessengerResId)
            }
        })

        viewModel.getBooks()

    }

}