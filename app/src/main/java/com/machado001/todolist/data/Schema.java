package com.machado001.todolist.data;

import android.provider.BaseColumns;

public final class Schema {

    private Schema() {
    }

    public static final class ToDoTable implements BaseColumns {
        public static final String TABLE_NAME = "to_do";
        public static final String COLUMN_NAME_PENDING = "pending";
        public static final String COLUMN_NAME_DONE = "done";
        public static final String COLUMN_NAME_IN_PROGRESS = "in_progress";
    }
}
