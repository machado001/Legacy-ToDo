package com.machado001.todolist.presentation.strategy;

import com.machado001.todolist.presentation.MainActivity;

public class DoneStrategy implements NavigationItemStrategy {
    private final MainActivity activity;

    public DoneStrategy(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void execute() {
        activity.doTransaction("Done","Done");
    }
}
