package com.example.tech_2.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by tech-2 on 20/9/16.
 */
public class OneFragment extends Fragment{

    public OneFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        final EditText prime = (EditText) getView().findViewById(R.id.prime);

        Button submit = (Button) getView().findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (!prime.getText().toString().isEmpty()) {
                    Boolean val = isPrime(Integer.parseInt("" + prime.getText()));
                    System.out.println("prime number " + prime.getText());
                    final String prime_text;

                    if (val) {
                        prime_text = "Its a prime number";
                    } else {
                        prime_text = "Its not prime number";
                    }
                    Toast.makeText(getActivity(), prime_text, Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getActivity(), "Empty Input", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    public Boolean isPrime(int p){
        if (p==2){
            return true;
        }

        else {
            for (int j=2;j< Math.sqrt(p);j++){
                if (p%j == 0) return false;
            }

            return true;
        }

    }



}
