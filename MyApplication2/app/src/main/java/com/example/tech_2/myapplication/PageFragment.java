package com.example.tech_2.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by tech-2 on 20/9/16.
 */
public class PageFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View  view;
        if (mPage == 1){

            view = inflater.inflate(R.layout.prime_page, container, false);
            final EditText prime = (EditText) view.findViewById(R.id.prime);

            Button submit = (Button) view.findViewById(R.id.submit);
            submit.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    try {
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
                    catch (Exception e){
                        Toast.makeText(getActivity(), "Wrong Input Type", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
        else {
            view = inflater.inflate(R.layout.fragment_two, container, false);
        }
        return view;
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