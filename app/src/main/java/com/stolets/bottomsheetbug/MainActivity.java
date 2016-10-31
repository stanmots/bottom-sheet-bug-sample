package com.stolets.bottomsheetbug;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @NonNull
    private List<String> mStringList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Fill sample data source.
        for (int i = 0; i < 5; ++i) {
            mStringList.add("Row #" + Integer.toString(i + 1));
        }

        // Configure RecyclerView.
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.sample_rv);
        recyclerView.setNestedScrollingEnabled(true);

        final SampleAdapter sampleAdapter = new SampleAdapter(this, mStringList);
        recyclerView.setAdapter(sampleAdapter);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
