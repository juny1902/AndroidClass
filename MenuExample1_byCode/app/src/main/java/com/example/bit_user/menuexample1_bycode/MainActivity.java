package com.example.bit_user.menuexample1_bycode;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    LinearLayout baseLayout;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "빨간색");
        menu.add(0, 2, 0, "초록색");
        menu.add(0, 3, 0, "파란색");

        SubMenu sMenu = menu.addSubMenu("버튼 변경 >>");
        sMenu.add(0, 4, 0, "회전");
        sMenu.add(0, 5, 0, "크기");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case 1:
                baseLayout.setBackgroundColor(Color.argb(0xFF,0xFF,0x00,0x00));
                return true;
            case 2:
                baseLayout.setBackgroundColor(Color.argb(0xFF,0x00,0xFF,0x00));
                return true;
            case 3:
                baseLayout.setBackgroundColor(Color.argb(0xFF,0x00,0x00,0xFF));
                return true;
            case 4:
                return true;
            case 5:

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1.findViewById(R.id.btn1);
        baseLayout.findViewById(R.id.baseLayout);
    }
}
