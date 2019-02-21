package com.example.otimdibossman.myjournal;

import android.provider.BaseColumns;

public final class myJournalDatabaseContractClass {
    private myJournalDatabaseContractClass(){}//cant be inherited or instatantiated

    public static final class usersEntry implements BaseColumns {

        public static  final String Table_Name="users";
        public static final String Column_Username="user_name";
        public static  final String Column_Password="password";
        public static   final String Column_Email="email";
        public static   final String Column_Hint="hint";
        public static  final String SQL_Create_Table="CREATE TABLE" +" "+ Table_Name +"("+_ID+ " " +"INTEGER Primary Key,"+Column_Username+""+" TEXT NOT NULL UNIQUE, "+Column_Email+" TEXT NOT NULL,"+Column_Password+"  TEXT NULL,"+Column_Hint+" TEXT NULL"+")";

    }
    public static final class notesEntry implements BaseColumns{
        public  static final String Table_Name="notes";
        public static  final String Column_Note_Title="noteTitle";
        public static  final String Column_Note_Text="noteText";
        public static  final  String Column_Note_Date="noteDate";
        public static  final String Column_User="user";
        public static  final String SQL_Create_Table="CREATE TABLE"+" "+ Table_Name+"("+_ID+""+"INTEGER Primary Key,"+Column_Note_Date+""+"NOT NULL,"+Column_Note_Title+""+"NOT NULL,"+Column_Note_Text+","+Column_User+""+"Text NOT NULL)";
    }
}
