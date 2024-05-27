package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.project.JsonTask;

import com.example.project.RecyclerViewAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener{

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a23gabli";
    private final String JSON_FILE = "spelare.json";
    private RecyclerViewAdapter adapter;
    private ArrayList<RecyclerViewItem> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        adapter = new RecyclerViewAdapter(this, items, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(RecyclerViewItem item) {
                Toast.makeText(MainActivity.this, item.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView view = findViewById(R.id.recycler_view);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);

        getJson();


    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", "" + json);
        if (json != null) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<RecyclerViewItem>>() {}.getType();
            List<RecyclerViewItem> newItems = gson.fromJson(json, type);


            if (newItems != null) {
                items.clear();
                items.addAll(newItems);
                adapter.notifyDataSetChanged();
            }
        }

    }


    private void getJson() {
        new JsonTask(this).execute(JSON_URL);
        new JsonFile(this, this).execute(JSON_FILE);
    }

    public void openAboutActivity(View view) {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

}

