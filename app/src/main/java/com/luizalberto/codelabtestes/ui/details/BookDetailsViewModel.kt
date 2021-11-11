package com.luizalberto.codelabtestes.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.book_details_fragment.*

class BookDetailsViewModel : ViewModel() {

    fun getBookDetails(fragment: Fragment, arguments: Bundle?) {

        var title  = arguments?.getString("title").toString()
        var author = arguments?.getString("author").toString()
        var description = arguments?.getString("description").toString()

        fragment.title.text = title
        fragment.author.text = author
        fragment.description.text = description

    }

}