package com.example.otimdibossman.myjournal;
import java.util.Date;

public class noteItem {


    private  int note_Id;
    private String note_title;
    private String note_text;
    private String note_date;


    public noteItem(String title, String date, String noteText) {


        this.note_title = title;
        this.note_date= date;
        this.note_text = noteText;


    }
    public noteItem(int id,String title, String date, String noteText){
        this.note_Id =id;
        this.note_title = title;
        this.note_date= date;
        this.note_text = noteText;

    }


    public String getTitle() {

        return note_title;
    }

    public String getDate() {

        return note_date;
    }

    public String getNoteText() {
        return note_text;
    }

    public void setDate(String newdate) {
        note_date = newdate;
        return;
    }

    public void setTitle(String newtitle) {
        note_title = newtitle;
        return;
    }

    public void setText(String text) {

        note_text = text;
    }




}
