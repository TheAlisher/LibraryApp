package com.example.libraryapp.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.libraryapp.R;
import com.example.libraryapp.ui.models.BookModel;

import java.io.Serializable;
import java.util.ArrayList;

public class MainFragment extends Fragment {

    private BookAdapter bookAdapter;
    private ArrayList<BookModel> card = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createMainRecyclerView(view);
        bookAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                openBookDescriptionFragment(position);
            }
        });
    }

    private void createMainRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_main);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        bookAdapter = new BookAdapter(card);
        recyclerView.setAdapter(bookAdapter);
    }

    private void openBookDescriptionFragment(int position) {
        Bundle bundle = new Bundle();
        Fragment bookDescriptionFragment = new BookDescriptionFragment();
        bundle.putSerializable(BookDescriptionFragment.ARG_BOOK_DATA,  card.get(position));
        bookDescriptionFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_main_container, bookDescriptionFragment).commit();
    }
}