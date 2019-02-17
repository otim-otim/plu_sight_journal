package com.example.otimdibossman.myjournal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class notesRecyclerAdapter extends RecyclerView.Adapter<notesRecyclerAdapter.MyViewHolder> {
    private final Context mContext;
    private final LayoutInflater layoutInflater;

    private final noteItem[] myNotes;

    public notesRecyclerAdapter(Context mContext, noteItem[] notes) {
        this.mContext = mContext;
        myNotes=notes;
        layoutInflater = LayoutInflater.from(mContext);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView mTextTitle;
        public final TextView mTextDate;

        public int mCurrentPosition;

        public MyViewHolder(View itemView) {

            super(itemView);
            mTextTitle = (TextView) itemView.findViewById(R.id.note_title);
            mTextDate = (TextView)itemView.findViewById(R.id.note_date);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {

            Intent noteIntent=new Intent(mContext,readNoteActivity.class);
            noteIntent.putExtra("note_position",mCurrentPosition);
            mContext.startActivity(noteIntent);
        }
    }
    @Override
    public notesRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)  {
        View view=layoutInflater.inflate(R.layout.note_list_item, parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(notesRecyclerAdapter.MyViewHolder holder, int position) {


        noteItem note= myNotes[position];

        holder.mTextDate.setText(note.getDate());
        holder.mTextTitle.setText(note.getTitle());

        holder.mCurrentPosition=position;


    }

    @Override
    public int getItemCount() {

        return myNotes.length;
    }
}
