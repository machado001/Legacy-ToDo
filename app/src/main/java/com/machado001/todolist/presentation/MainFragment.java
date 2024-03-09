package com.machado001.todolist.presentation;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import  com.machado001.todolist.databinding.FragmentBinding;

import com.machado001.todolist.R;

public class MainFragment extends Fragment {

    public MainFragment() {
        super(R.layout.fragment);
    }

    public static MainFragment newInstance(String pageTitle) {
        Bundle bundle = new Bundle();
        bundle.putString("pageTitle", pageTitle);

        MainFragment fragment = new MainFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        FragmentBinding binding = com.machado001.todolist.databinding.FragmentBinding.bind(view);
        super.onViewCreated(binding.getRoot(), savedInstanceState);

        Bundle args = getArguments();

        if (args != null) {
            String str =  args.getString("pageTitle");
            binding.fragmentTvTitle.setText(str);

        }
    }
}
