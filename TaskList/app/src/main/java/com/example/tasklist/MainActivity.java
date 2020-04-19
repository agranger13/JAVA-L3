package com.example.tasklist;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.tasklist.ui.main.SectionsPagerAdapter;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Page_List pageList = new Page_List();
    private Page_Add pageAdd = new Page_Add();
    private Page_Calendar pageCalendar = new Page_Calendar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        SetUpViewPager(viewPager);
    }

    public void SetUpViewPager (ViewPager viewpage){
        AdapterTab Adapter = new AdapterTab(getSupportFragmentManager());

        Adapter.AddFragmentPage(pageList, "Tasks");
        Adapter.AddFragmentPage(pageAdd, "Add");
        Adapter.AddFragmentPage(pageCalendar, "Calendar");
        //We Need Fragment class now

        viewpage.setAdapter(Adapter);
    }


    public void onClick(View view) {
        if(view.getId() == R.id.buttonAdd){
            Task task = pageAdd.createTask();
            pageList.notifyAdd(task);
        }
    }

}