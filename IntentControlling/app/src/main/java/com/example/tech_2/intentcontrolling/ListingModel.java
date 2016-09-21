package com.example.tech_2.intentcontrolling;

/**
 * Created by tech-2 on 21/9/16.
 */
public class ListingModel {

    private String value;

    public ListingModel(String val){
        this.value = val;
    }

    public void setValue(String val){
        if (val !=null) this.value = val;
        else this.value = "";
    }

    public String getValue(){
        if (this.value == null) return "";
        else return this.value;
    }

}
