package com.example.otimdibossman.myjournal;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class editNoteActivity extends AppCompatActivity {

    EditText editNoteTitle;
    EditText editNoteText;
    int noteID;
    myJournalOpenHelper mDBOpenHelper;
    SQLiteDatabase DB;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);
        editNoteTitle=(EditText) findViewById(R.id.edit_title);
        editNoteText=(EditText) findViewById(R.id.edit_notetext);

        noteID=getStartingIntent();
        DB=mDBOpenHelper.getReadableDatabase();

        //editNoteTitle.setText();
       // editNoteText.setText();

    }

    private int getStartingIntent() {
        int mNote=0;
        Intent getTheIntent=getIntent();

        if(getTheIntent!=null){
            if(getTheIntent.hasExtra("note_id")){
                 mNote=getTheIntent.getIntExtra("note_id",1);


            }

        }
        return mNote;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.editnote_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.action_save:
               //noteItem editedNote=noteSave(position);

               Intent backIntent=new Intent(editNoteActivity.this,readNoteActivity.class);
               // backIntent.putExtra("edited note",passData(editedNote));

                break;
            case R.id.action_cancel:
               // editNoteTitle.setText(myNotes[position].getTitle());
               // editNoteText.setText(myNotes[position].getNoteText());
                break;
            case R.id.action_share:
              //  noteSave(position);

               // noteShare(myNotes[position]);
                break;


        }
        return super.onOptionsItemSelected(item);
    }

    private void noteShare(noteItem myNote) {
        String title=myNote.getTitle();
        String text=myNote.getNoteText();
        String mimeType="text/plain";
        ShareCompat.IntentBuilder.from(this)
                                 .setType(mimeType)
                                 .setChooserTitle(title)
                                 .setText(text)
                                 .startChooser();
    }

    //private noteItem noteSave(int position) {
        //myNotes[position].setTitle(editNoteTitle.getText().toString());
       // myNotes[position].setText(editNoteText.getText().toString());
        //return myNotes[position];
        //Main2Activity.mNotesRecyclerAdapter.notifyDataSetChanged();

        
   // }
    protected String[] passData(noteItem ed_note){
        String[] getdata=new String[2];
        getdata[0]=ed_note.getTitle().toString();
        getdata[1]=ed_note.getNoteText().toString();
        return getdata;
    }
    @Override
    protected void onResume(){
        super.onResume();
        //notifyDatasetChanged();
    }

}
