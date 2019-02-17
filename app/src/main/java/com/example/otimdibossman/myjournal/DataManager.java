package com.example.otimdibossman.myjournal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.otimdibossman.myjournal.myJournalDatabaseContractClass.notesEntry;
import com.example.otimdibossman.myjournal.myJournalDatabaseContractClass.usersEntry;

import java.util.ArrayList;
import java.util.List;

import static com.example.otimdibossman.myjournal.myJournalDatabaseContractClass.notesEntry.Column_Note_Date;
import static com.example.otimdibossman.myjournal.myJournalDatabaseContractClass.notesEntry.Column_Note_Text;
import static com.example.otimdibossman.myjournal.myJournalDatabaseContractClass.notesEntry.Column_Note_Title;
import static com.example.otimdibossman.myjournal.myJournalDatabaseContractClass.usersEntry.Column_Email;
import static com.example.otimdibossman.myjournal.myJournalDatabaseContractClass.usersEntry.Column_Username;

public class DataManager {

    private static DataManager  myInstance;

    private List<UserItem> mUser=new ArrayList<UserItem>();
    private List<noteItem> mNotes=new ArrayList<noteItem>();


    public static DataManager getInstance(){
        if(myInstance==null){
            myInstance=new DataManager();
        }
        return  myInstance;
    }

    public static void loadFromDatabase(myJournalOpenHelper dbhelper){
        SQLiteDatabase db=dbhelper.getReadableDatabase();
        final String[] userColumns = {Column_Username, Column_Email};
        final Cursor users_cursor = db.query(usersEntry.Table_Name, userColumns, null, null, null, null, Column_Username);
        loadUsersFromDatabase(users_cursor);
        final String[] noteColumns = {Column_Note_Date, Column_Note_Title, Column_Note_Text};
        final Cursor notes_cursor = db.query(notesEntry.Table_Name, noteColumns, null, null, null, null, Column_Note_Date);
        loadNotesFromDatabase(notes_cursor);
    }

    private static void loadNotesFromDatabase(Cursor cursor) {
        int noteDatePos=cursor.getColumnIndex(Column_Note_Date);
        int noteTitlePos=cursor.getColumnIndex(Column_Note_Title);
        int noteTextPos=cursor.getColumnIndex(Column_Note_Text);

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
        int usernamePos=cursor.getColumnIndex(Column_Username);
        int emailPos=cursor.getColumnIndex(Column_Email);

        DataManager dm=getInstance();
        dm.mUser.clear();
        while(cursor.moveToNext()){
            String userName=cursor.getString(usernamePos);
            String userEmail=cursor.getString(emailPos);
            UserItem user=new UserItem(userName,userEmail,"","");
            dm.mUser.add(user);

        }
        cursor.close();
    }
}
