package com.machado001.todolist.presentation.strategy;

import com.machado001.todolist.presentation.MainActivity;

public class PendingStrategy implements NavigationItemStrategy {
    private final MainActivity activity;

    public PendingStrategy(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void execute() {
        activity.doTransaction("Pending","Pending");
    }
}
