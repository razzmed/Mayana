package com.example.mayana;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class EmployeesDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "employees.db";
    private static final int DB_VERSION = 1;

    public EmployeesDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(EmployeesContract.EmployeesEntry.CREATE_COMMAND);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(EmployeesContract.EmployeesEntry.DROP_COMMAND);
        onCreate(sqLiteDatabase);
    }
}
