package com.example.otimdibossman.myjournal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.otimdibossman.myjournal.myJournalDatabaseContractClass.notesEntry;
import com.example.otimdibossman.myjournal.myJournalDatabaseContractClass.usersEntry;

import java.util.ArrayList;
import java.util.List;

import static android.provider.BaseColumns._ID;

import static com.example.otimdibossman.myjournal.myJournalDatabaseContractClass.notesEntry;
import static com.example.otimdibossman.myjournal.myJournalDatabaseContractClass.usersEntry;


public class DataManager {

    private static DataManager  myInstance;
    private static String column_note_date;

    private List<UserItem> mUser=new ArrayList<UserItem>();
    private List<noteItem> mNotes=new ArrayList<noteItem>();
    private String Column_Note_Date;


    public static DataManager getInstance(){
        if(myInstance==null){
            myInstance=new DataManager();
        }
        return  myInstance;
    }

    public static void loadFromDatabase(myJournalOpenHelper dbhelper){
        SQLiteDatabase db=dbhelper.getReadableDatabase();
        final String[] userColumns = {
                usersEntry.Column_Username,
                usersEntry.Column_Email,
                _ID};
        final Cursor users_cursor = db.query(usersEntry.Table_Name, userColumns, null, null, null, null, usersEntry.Column_Username);
        loadUsersFromDatabase(users_cursor);
        final String[] noteColumns = {
                notesEntry.Column_Note_Date,
                notesEntry.Column_Note_Title,
                notesEntry.Column_Note_Text,
                _ID};
        final Cursor notes_cursor = db.query(notesEntry.Table_Name, noteColumns, null, null, null, null, column_note_date);
        loadNotesFromDatabase(notes_cursor);
    }

    private static void loadNotesFromDatabase(Cursor cursor) {
        int noteDatePos=cursor.getColumnIndex(notesEntry.Column_Note_Date);
        int noteTitlePos=cursor.getColumnIndex(notesEntry.Column_Note_Title);
        int noteTextPos=cursor.getColumnIndex(notesEntry.Column_Note_Text);

        DataManager dm=getInstance();
        dm.mNotes.clear();

        while(cursor.moveToNext()){
            String noteDate=cursor.getString(noteDatePos);
            String noteTitle=cursor.getString(noteTitlePos);
            String noteText=cursor.getString(noteTextPos);
            noteItem note=new noteItem(noteTitle,noteDate,noteText);
            dm.mNotes.add(note);

        }
        cursor.close();
    }

    private static void loadUsersFromDatabase(Cursor cursor) {
        int usernamePos=cursor.getColumnIndex(usersEntry.Column_Username);
        int emailPos=cursor.getColumnIndex(usersEntry.Column_Email);

        DataManager dm=getInstance();
        dm.mUser.clear();
        while(cursor.moveToNext()){
            String userName=cursor.getString(usernamePos);
           // String userEmail=cursor.getString(emailPos);
            UserItem user=new UserItem(userName,"","",null);
            dm.mUser.add(user);

        }
        cursor.close();
    }
}
