package com.example.tasklist;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class Page_Add extends Fragment {
    EditText dateStart;
    EditText dateEnd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View Page = inflater.inflate(R.layout.page_add, container, false);
        return Page;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        dateStart = getView().findViewById(R.id.dateStartInput);
        dateStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDatePicker(v,"start");
            }
        });

        dateEnd = getView().findViewById(R.id.dateEndInput);
        dateEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDatePicker(v,"end");
            }
        });
    }

    public void setDatePicker(View v, final String which){
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);
        // date picker dialog
        DatePickerDialog picker = new DatePickerDialog(this.getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        if(which.compareTo("start") == 0)
                            dateStart.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        else
                            dateEnd.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, year, month, day);
        picker.show();
    }

    public Task createTask(){
        String name = ((EditText)getView().findViewById(R.id.nameInput)).getText().toString();
        String dateEnd = ((EditText)getView().findViewById(R.id.dateEndInput)).getText().toString();
        String dateStart = ((EditText)getView().findViewById(R.id.dateStartInput)).getText().toString();
        Task task = new Task(name,dateStart,dateEnd);
        return task;
    }
}
