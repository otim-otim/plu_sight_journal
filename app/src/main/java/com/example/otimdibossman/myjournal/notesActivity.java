package com.example.otimdibossman.myjournal;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

public class notesActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView mRecycler;
    LinearLayoutManager mLayoutManager;


    private veryManyNotes manyNotes= new veryManyNotes();
    private noteItem[] myNotes=manyNotes.notesArrayFaker();
    notesRecyclerAdapter myAdapter=new notesRecyclerAdapter(this,myNotes);
    FloatingActionButton addNote;
    SearchView mSearchView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        mRecycler=(RecyclerView) findViewById(R.id.my_recycler);
        mLayoutManager=new LinearLayoutManager(this);
        mSearchView=(SearchView) findViewById(R.id.search_view);
        mRecycler.setLayoutManager(mLayoutManager);

        mRecycler.setHasFixedSize(true);
        mRecycler.setAdapter(myAdapter);

        addNote=(FloatingActionButton) findViewById(R.id.fab_add_btn);
        addNote.setOnClickListener(this);




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater myInflater=getMenuInflater();
        myInflater.inflate(R.menu.appmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case (R.id.item_add_note):
                Intent add_note_intent=new Intent(this,AddNoteActivity.class);
                return true;

            case (R.id.item_search):
                //mSearchView.setVisible();
                // mSearchView.setViT
                Toast.makeText(this,"you pressed the search button",Toast.LENGTH_LONG);
                return true;

            case (R.id.item_settings):
                Intent settings_intent=new Intent(this,SettingsActivity.class);
                return true;

            case (R.id.item_share):
                Toast.makeText(this,"you pressed the share button",Toast.LENGTH_LONG);
                //Intent share_intent=new Intent(this,ShareActivity.class);
                return true;


        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if(view==addNote){
            Intent add_note_intent=new Intent(this,AddNoteActivity.class);
        }

    }
}
