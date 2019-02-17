package com.example.otimdibossman.myjournal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class myJournalOpenHelper extends SQLiteOpenHelper {
    public static String Database_Name="myJournal.db";
    public static int Database_Version=1;
    public myJournalOpenHelper(@Nullable Context context) {
        super(context, Database_Name, null, Database_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(myJournalDatabaseContractClass.usersEntry.SQL_Create_Table);
        db.execSQL(myJournalDatabaseContractClass.notesEntry.SQL_Create_Table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
