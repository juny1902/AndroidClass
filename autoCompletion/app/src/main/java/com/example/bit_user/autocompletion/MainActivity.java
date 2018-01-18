package com.example.bit_user.autocompletion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autoComp;
    MultiAutoCompleteTextView multiComp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] items = {"Rock","Metal","Pops","Ballad","Blues","Jazz","Funk"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,items);

        autoComp = findViewById(R.id.autoComp1);
        autoComp.setAdapter(adapter);

        multiComp = findViewById(R.id.multiComp1);
        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
        multiComp.setTokenizer(token);
        multiComp.setAdapter(adapter);
    }
}
