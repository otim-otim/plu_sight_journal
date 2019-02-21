package com.example.otimdibossman.myjournal;

public class veryManyNotes {
    noteItem[] manyItems = new noteItem[150];

    noteItem note;











     public noteItem[] notesArrayFaker(){
        for (int n = 1; n < 151; n++) {
            String Title = "title"+n;
            String date = "day" +n;

            String textadd = "i ve written in this program";
            String Text = "this is really " + "note number" + n + textadd;

             note = new noteItem(Title, date, Text);
            manyItems[n-1] = note;


        }
        return manyItems;
    }
}





