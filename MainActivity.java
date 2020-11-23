package com.example.customadapterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    UserListAdapter adapter;
    ListView listView;
    ArrayList<User> users;

    public ArrayList<User> loadMovies() throws IOException {
        InputStream stream = getAssets().open("users.json");
        InputStreamReader reader = new InputStreamReader(stream);
        Gson gson = new Gson();
        M m = gson.fromJson(reader, M.class);
        return m.users;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);

        try {
            users = loadMovies();
        } catch (IOException e) {
            e.printStackTrace();
        }
        adapter = new UserListAdapter(this, users);

        listView.setAdapter(adapter);
    }
}
