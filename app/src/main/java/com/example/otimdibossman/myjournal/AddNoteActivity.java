package com.example.otimdibossman.myjournal;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity  {

    EditText mEditTitle;
    EditText mEditNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        mEditTitle=(EditText) findViewById(R.id.edit_title);
        mEditNote=(EditText)findViewById(R.id.edit_note);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater my_inflater=getMenuInflater();
        my_inflater.inflate(R.menu.add_note_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.item_save:
                Toast.makeText(this,"you are saving the note",Toast.LENGTH_LONG);
                return true;
            case R.id.item_back:
                Intent back_intent=new Intent(this,notesActivity.class);
                return true;

            case R.id.item_cancel:
                mEditTitle.setText("");
                mEditNote.setText("");
                return true;

            case R.id.item_save_share:
                //code to save in database
                String share_title= mEditTitle.getText().toString();
                String share_note= mEditNote.getText().toString();
               shareNote(share_note,share_title);
               return true;


        }
        return super.onOptionsItemSelected(item);
    }
    //function to save in the database
    public void saveNote(){

    }
    //function for sharinng a note
    public void shareNote(String notetoshare,String titletonote){
        String mimetype="text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setChooserTitle(titletonote)
                .setType(mimetype)
                .setText(notetoshare)
                .startChooser();

    }
}
