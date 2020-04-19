package com.example.tasklist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Page_List extends Fragment {
    private RecyclerView recyclerView;
    private AdapterList mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Task> mDataset;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View Page = inflater.inflate(R.layout.page_list, container, false);
        buildAdapter(Page);

        return Page;
    }

    private void buildAdapter(View v){
        recyclerView = (RecyclerView)v.findViewById(R.id.recylclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(v.getContext());
        recyclerView.setLayoutManager(layoutManager);

        mDataset = new ArrayList<Task>();
        mDataset.add(new Task("Nom","DateDebut","DateFin"));
        mDataset.add(new Task("Nom","DateDebut","DateFin"));
        mDataset.add(new Task("Nom","DateDebut","DateFin"));

        mAdapter = new AdapterList(mDataset);
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new AdapterList.OnItemClickListener() {
            public void onDeleteClick(int position) {
                notifyRemove(position);
            }
        });
    }

    public void notifyAdd(Task newTask){
        mDataset.add(newTask);
        mAdapter.notifyItemInserted(mDataset.size()-1);
    }

    public void notifyRemove(int position){
        mDataset.remove(position);
        mAdapter.notifyItemRemoved(position);
    }
}
