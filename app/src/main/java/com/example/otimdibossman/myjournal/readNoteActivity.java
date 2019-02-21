package com.example.otimdibossman.myjournal;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class readNoteActivity extends AppCompatActivity implements View.OnClickListener {
         TextView textDate;
         TextView textTitle;
         TextView textNote;
         FloatingActionButton editButton;
         FloatingActionButton nextButton;
         veryManyNotes manynotes=new veryManyNotes();
         noteItem[] notes=manynotes.notesArrayFaker();
         int notePosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_note);

        textDate =(TextView) findViewById(R.id.date_note);
        textTitle =(TextView)findViewById(R.id.title_note);
        textNote =(TextView) findViewById(R.id.text_note);
        editButton=(FloatingActionButton)findViewById(R.id.edit_fab);
        nextButton=(FloatingActionButton)findViewById(R.id.movenext_fab);
        editButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        //collect the intent that started this activity
        Intent intentThatStartedThisActivity=getIntent();

        if(intentThatStartedThisActivity !=null){
            if(intentThatStartedThisActivity.hasExtra("note_position")){
                 notePosition=intentThatStartedThisActivity.getIntExtra("note_position",0);
                textDate.setText(notes[notePosition].getDate());
                textTitle.setText(notes[notePosition].getTitle());
                textNote.setText(notes[notePosition].getNoteText());
            }
            else if(intentThatStartedThisActivity.hasExtra("edited note")){
                String[] takeData=intentThatStartedThisActivity.getStringArrayExtra("edited note");
                textDate.setText(notes[notePosition].getDate());
                textTitle.setText(notes[notePosition].getTitle());
                textNote.setText(notes[notePosition].getNoteText());
            }
        }



    }

    @Override
    public void onClick(View view) {
        if(view==editButton){
            Intent editIntent=new Intent(readNoteActivity.this,editNoteActivity.class);
            editIntent.putExtra("note_position",notePosition);
            startActivity(editIntent);
        }
        else{
            textDate.setText(notes[notePosition+1].getDate());
            textTitle.setText(notes[notePosition+1].getTitle());
            textNote.setText(notes[notePosition+1].getNoteText());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.readnote_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.edit_readnote:
                Intent editIntent=new Intent(readNoteActivity.this,editNoteActivity.class);
                editIntent.putExtra("note_position",notePosition);
                startActivity(editIntent);
                break;
            case R.id.delete_readnote:
                Toast.makeText(this,"trying to delete note",Toast.LENGTH_LONG);
                break;

            case R.id.back_readnote:
                Intent backIntent=new Intent(this,Main2Activity.class);
                startActivity(backIntent);
                break;
            case R.id.thought_readnote:
                Toast.makeText(this,"adding a thought option",Toast.LENGTH_LONG);
                break;
            case R.id.readthought_readnote:
                Toast.makeText(this,"read thoughts to this note",Toast.LENGTH_LONG);
                break;
            case R.id.moveback_readnote:
                textDate.setText(notes[notePosition-1].getDate());
                textTitle.setText(notes[notePosition-1].getTitle());
                textNote.setText(notes[notePosition-1].getNoteText());
                break;
            case R.id.share_readnote:
                Toast.makeText(this,"trying to share",Toast.LENGTH_LONG);


        }
        return super.onOptionsItemSelected(item);
    }
}
