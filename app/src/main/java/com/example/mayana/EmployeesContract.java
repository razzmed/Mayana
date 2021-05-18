package com.example.mayana;

import android.provider.BaseColumns;

public class EmployeesContract {
    public static final class EmployeesEntry implements BaseColumns {
        public static final String TABLE_NAME = "employees";
        public static final String COLUMN_EMPLOYER_NAME = "employer_name";
        public static final String COLUMN_EMPLOYER_POSITION = "employer_position";
        public static final String COLUMN_EMPLOYER_SALARY = "employer_salary";
        public static final String COLUMN_PERSONAL_WAGE = "personal_wage";
        public static final String COLUMN_MONTH_SALARY = "month_salary";

        public static final String TYPE_TEXT = "TEXT";
        public static final String TYPE_INTEGER = "INTEGER";

        public static final String CREATE_COMMAND = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                "(" + _ID + " " + TYPE_INTEGER + " PRIMARY KEY AUTOINCREMENT, " + COLUMN_EMPLOYER_NAME +
                " " + TYPE_TEXT + ", " + COLUMN_EMPLOYER_POSITION + " " + TYPE_TEXT + ", " + COLUMN_EMPLOYER_SALARY +
                " " + TYPE_TEXT + ", " + COLUMN_PERSONAL_WAGE + " " + TYPE_TEXT + ", " + COLUMN_MONTH_SALARY + " " + TYPE_TEXT + ") ";

        public static final String DROP_COMMAND = "DROP TABLE IF EXISTS" + TABLE_NAME;


    }
}
