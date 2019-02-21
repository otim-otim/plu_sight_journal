package com.example.otimdibossman.myjournal;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.otimdibossman.myjournal.myJournalDatabaseContractClass.notesEntry;

public class notesRecyclerAdapter extends RecyclerView.Adapter<notesRecyclerAdapter.MyViewHolder> {
    private final Context mContext;
    private final LayoutInflater layoutInflater;

   // private final noteItem[] myNotes;
    private  Cursor mCursor;
    private int mDatePos;
    private int mTitlePos;
    private int mIdPos;
    private int mText;

    public notesRecyclerAdapter(Context mContext, Cursor notes) {
        this.mContext = mContext;
        mCursor=notes;
        layoutInflater = LayoutInflater.from(mContext);
        populateColumnPositions();
    }

    private void populateColumnPositions() {
        if(mCursor==null){
            return;
        }
        //get colmn index positions from cursor
        mDatePos = mCursor.getColumnIndex(notesEntry.Column_Note_Date);
        mTitlePos = mCursor.getColumnIndex(notesEntry.Column_Note_Title);
        mIdPos = mCursor.getColumnIndex(notesEntry._ID);
        mText = mCursor.getColumnIndex(notesEntry.Column_Note_Text);
    }
    public  void changeCursor(Cursor cursor){
        if(mCursor!= null){
            mCursor.close();
        }
        mCursor=cursor;
        populateColumnPositions();
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView mTextTitle;
        public final TextView mTextDate;

        public int mId;

        public MyViewHolder(View itemView) {

            super(itemView);
            mTextTitle = (TextView) itemView.findViewById(R.id.note_title);
            mTextDate = (TextView)itemView.findViewById(R.id.note_date);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {

            Intent noteIntent=new Intent(mContext,readNoteActivity.class);
            noteIntent.putExtra("note_id",mId);
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


        mCursor.moveToPosition(position);
        String noteDate=mCursor.getString(mDatePos);
        String noteTitle=mCursor.getString(mTitlePos);
        int noteId=mCursor.getInt(mIdPos);

        holder.mTextDate.setText(noteDate);
        holder.mTextTitle.setText(noteTitle);

        holder.mId=noteId;


    }

    @Override
    public int getItemCount() {

        return mCursor==null?0: mCursor.getCount();
    }
}
