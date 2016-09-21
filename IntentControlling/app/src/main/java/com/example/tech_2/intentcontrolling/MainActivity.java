package com.example.tech_2.intentcontrolling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.addText) TextView addText;
    @BindView(R.id.btn) Button btn;
    ArrayList<String> allTexts = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        System.out.println("btn "+btn);
        System.out.println("btn "+btn.getText());

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Do stuff here
                Intent intent = new Intent(getBaseContext(), ListingText.class);
                if(addText.getText().toString() != null && !addText.getText().toString().isEmpty() ) {
                    Intent addbackValues = getIntent();

                    if (addbackValues.getStringArrayListExtra("addingText") != null){
                        allTexts = addbackValues.getStringArrayListExtra("addingText");
                        System.out.println("all text main activity "+allTexts);
                    }
                    allTexts.add((String) addText.getText().toString());

                    intent.putExtra("addingText", allTexts);
                    startActivity(intent);
                }
            }
        });




    }
}
