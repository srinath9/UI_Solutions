package com.example.tech_2.intentcontrolling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListingText extends AppCompatActivity {

    private List<ListingModel> allTextValues = new ArrayList<>();
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindView(R.id.goback)  Button btn;
    private ListingAdapter mAdapter;
    ArrayList<String> listval;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing_text);
        ButterKnife.bind(this);

        mAdapter = new ListingAdapter(allTextValues);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goback = new Intent(getBaseContext() , MainActivity.class);
                List<ListingModel> listValues = mAdapter.getAllList();
                listval.clear();
                for(ListingModel each_val : listValues){
                    listval.add(each_val.getValue());
                }
                goback.putStringArrayListExtra("addingText" , listval);
                mAdapter.notifyDataSetChanged();
                startActivity(goback);
            }
        });

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);

        Intent intent = getIntent();
        listval = intent.getStringArrayListExtra("addingText");
        for ( String val : listval){
            allTextValues.add(new ListingModel(val));
        }
    }
}
