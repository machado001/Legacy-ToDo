package com.machado001.todolist.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.machado001.todolist.R;
import com.machado001.todolist.databinding.ActivityMainBinding;
import com.machado001.todolist.domain.ItemModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.mainBottomNav.setOnItemSelectedListener( listener -> {

            ArrayList<ItemModel> list = new ArrayList<>();

            list.add(new ItemModel("title","description"));
            list.add(new ItemModel("title","description"));

            if (listener.getItemId() == R.id.item_done) {

                Fragment fragment = MainFragment.newInstance("DONE");
               getSupportFragmentManager()
                       .beginTransaction()
                       .setReorderingAllowed(true)
                       .replace(R.id.main_frag,fragment)
                       .commit();

                Toast.makeText(this,"DONE ITEM",Toast.LENGTH_LONG).show();
            }

            if (listener.getItemId() == R.id.item_progress) {

                MainFragment fragment = MainFragment.newInstance("PROGRESS");
                getSupportFragmentManager()
                        .beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.main_frag,fragment)
                        .commit();
                Toast.makeText(this,"IN PROGRESS ITEM",Toast.LENGTH_LONG).show();
            }

            if (listener.getItemId() == R.id.item_pending) {

                MainFragment fragment = MainFragment.newInstance("PENDING");
                getSupportFragmentManager()
                        .beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.main_frag,fragment)
                        .commit();
                Toast.makeText(this,"PENDING ITEM",Toast.LENGTH_LONG).show();
            }
            return true;
        });
    }
}