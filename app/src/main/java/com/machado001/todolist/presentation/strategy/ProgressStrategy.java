package com.machado001.todolist.presentation.strategy;

import com.machado001.todolist.presentation.MainActivity;

public class ProgressStrategy implements NavigationItemStrategy {
    private final MainActivity activity;

    public ProgressStrategy(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void execute() {
        activity.doTransaction("In progress","In progress");
    }
}