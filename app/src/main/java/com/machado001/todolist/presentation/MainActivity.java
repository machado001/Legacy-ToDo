package com.machado001.todolist.presentation;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.machado001.todolist.R;
import com.machado001.todolist.databinding.ActivityMainBinding;
import com.machado001.todolist.presentation.strategy.DoneStrategy;
import com.machado001.todolist.presentation.strategy.NavigationItemStrategy;
import com.machado001.todolist.presentation.strategy.PendingStrategy;
import com.machado001.todolist.presentation.strategy.ProgressStrategy;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private final Map<Integer, NavigationItemStrategy> strategyMap = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupStrategies();

        binding.mainBottomNav.setOnItemSelectedListener(item -> {
            NavigationItemStrategy strategy = strategyMap.get(item.getItemId());
            if (strategy != null) {
                strategy.execute();
            }
            return true;
        });
    }

    private void setupStrategies() {
        strategyMap.put(R.id.item_progress, new ProgressStrategy(this));
        strategyMap.put(R.id.item_pending, new PendingStrategy(this));
        strategyMap.put(R.id.item_done, new DoneStrategy(this));
    }

    public void doTransaction(String title, String toast) {
        MainFragment fragment = MainFragment.newInstance(title);
        getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.main_frag, fragment)
                .commit();
        Toast.makeText(this, toast, Toast.LENGTH_LONG).show();
    }
}