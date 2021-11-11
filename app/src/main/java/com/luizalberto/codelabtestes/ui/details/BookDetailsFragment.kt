package com.luizalberto.codelabtestes.ui.details

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.luizalberto.codelabtestes.R
import com.luizalberto.codelabtestes.extensions.navigateWithAnimationsReverse
import kotlinx.android.synthetic.main.book_details_fragment.*

class BookDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = BookDetailsFragment()
    }

    private lateinit var viewModel: BookDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.book_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BookDetailsViewModel::class.java)

        viewModel.getBookDetails(this, arguments)

        button_back.setOnClickListener {
            findNavController().navigateWithAnimationsReverse(R.id.action_bookDetailsFragment_to_booksFragment)
        }
    }

}