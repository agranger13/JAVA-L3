package com.example.tasklist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ExampleViewHolder> {
    private ArrayList<Task> mExampleList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView mNomTache;
        public TextView mDateEnd;
        public TextView mDateStart;
        public Button deleteButton;
        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mNomTache = itemView.findViewById(R.id.nomText);
            mDateStart = itemView.findViewById(R.id.dateStartText);
            mDateEnd = itemView.findViewById(R.id.dateEndText);
            deleteButton = itemView.findViewById(R.id.removeButton);

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }

    public AdapterList(ArrayList<Task> exampleList) {
        mExampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v,mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        Task currentItem = mExampleList.get(position);
        holder.mNomTache.setText(currentItem.getName());
        holder.mDateStart.setText(currentItem.getDateSart());
        holder.mDateEnd.setText(currentItem.getDateEnd());

    }
    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
