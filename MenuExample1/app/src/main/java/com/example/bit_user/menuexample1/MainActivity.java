package com.example.bit_user.menuexample1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout baseLayout;
    Button button1;
    static int angle;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.argb(0x33, 0xFF, 0x00, 0x00));
                return true;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.argb(0x33, 0x00, 0xFF, 0x00));
                return true;
            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.argb(0x33, 0x00, 0x00, 0xFF));
                return true;
            case R.id.subSize:
                if (button1.getScaleX() == 1)
                    button1.setScaleX(2);
                else
                    button1.setScaleX(1);
                return true;
            case R.id.subRotate:
                angle += 45;
                button1.setRotation(angle);
                return true;
        }
        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater mInflater = getMenuInflater();
        if (v == button1) {
            menu.setHeaderTitle("배경색 확장");
            menu.setHeaderIcon(R.drawable.ic_search_black_24dp);
            mInflater.inflate(R.menu.menu2, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemCyan:
                baseLayout.setBackgroundColor(Color.argb(0x33, 0x00, 0xFF, 0xFF));
                break;
            case R.id.itemMagenta:
                baseLayout.setBackgroundColor(Color.argb(0x33, 0xFF, 0x00, 0xFF));
                break;
            case R.id.itemYellow:
                baseLayout.setBackgroundColor(Color.argb(0x33, 0xFF, 0xFF, 0x00));
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baseLayout = findViewById(R.id.baseLayout);
        button1 = findViewById(R.id.btn1);
        registerForContextMenu(button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast msg = Toast.makeText(MainActivity.this, "토스트 테스트", Toast.LENGTH_SHORT);
                Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                int xOffset = (int) (Math.random() * display.getWidth());
                int yOffset = (int) (Math.random() * display.getHeight());

                msg.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);
                msg.show();
            }
        });

    }


}
