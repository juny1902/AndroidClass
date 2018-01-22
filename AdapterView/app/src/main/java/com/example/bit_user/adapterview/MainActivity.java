package com.example.bit_user.adapterview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText entryName;
    Button btnAdd;
    ListView listV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트뷰 테스트");
        entryName = findViewById(R.id.entryListElement);
        entryName.setSingleLine();
        btnAdd = findViewById(R.id.btnAdd);
        final ArrayList<String> lists = new ArrayList<String>();
        listV = findViewById(R.id.listView1);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, lists);
        listV.setAdapter(adapter);
        entryName.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER){
                    btnAdd.callOnClick();
                }
                return false;
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lists.add(entryName.getText().toString());
                adapter.notifyDataSetChanged();
                entryName.setText("");
            }
        });

        listV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                lists.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}
