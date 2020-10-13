package com.example.libraryapp.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.libraryapp.R;
import com.example.libraryapp.ui.models.BookModel;

public class BookDescriptionFragment extends Fragment {

    public static final String ARG_BOOK_DATA = "book_data";

    private BookModel bookModel;
    private ImageView imageBook;
    private TextView textBookName;
    private TextView textBookAuthor;
    private TextView textBookDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_book_description, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializationViews(view);
        bundleGetArguments();
    }

    private void initializationViews(View view) {
        imageBook = view.findViewById(R.id.image_bookDescription_book);
        textBookName = view.findViewById(R.id.text_bookDescription_name);
        textBookAuthor = view.findViewById(R.id.text_bookDescription_author);
        textBookDescription  = view.findViewById(R.id.text_bookDescription_description);
    }

    private void bundleGetArguments() {
        bookModel = (BookModel) requireArguments().getSerializable(ARG_BOOK_DATA);
        if (bookModel != null) {
            imageBook.setImageResource(bookModel.getImageBook());
            textBookName.setText(bookModel.getTextBookName());
            textBookAuthor.setText(bookModel.getTextBookAuthor());
            textBookDescription.setText(bookModel.getTextBookDescription());
        }
    }
}