package com.example.bit_user.googlemaps2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LatLng bitLatLng = new LatLng(37.494808, 127.027601);
    LatLng homeLatLng = new LatLng(37.296673, 126.884564);
    Button btnZoomIn, btnZoomOut;
    Switch swMusic;
    Intent intent;
    TextView textProgress;
    ProgressBar batteryProgress;
    BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if (action.equals(Intent.ACTION_BATTERY_CHANGED)) {
                int remain = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                batteryProgress.setProgress(remain);
                textProgress.setText(remain+"%");
            }

        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(br);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter iFilter = new IntentFilter();
        iFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(br, iFilter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        btnZoomIn = findViewById(R.id.btnZoomIn);
        btnZoomOut = findViewById(R.id.btnZoomOut);
        swMusic = findViewById(R.id.swMusic);
        intent = new Intent(this, MusicService.class);
        batteryProgress = findViewById(R.id.batteryProgress);
        textProgress = findViewById(R.id.textProgress);
        btnZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.moveCamera(CameraUpdateFactory.zoomIn());
            }
        });

        btnZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.moveCamera(CameraUpdateFactory.zoomOut());
            }
        });

        swMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    startService(intent);
                    android.util.Log.i("서비스 테스트", "startService()");
                } else {
                    stopService(intent);
                    android.util.Log.i("서비스 테스트", "stopService()");
                }
            }
        });
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        // Add a marker in Sydney and move the camera
        LatLng hollywood = new LatLng(34.134164, -118.321510);
        mMap.addMarker(new MarkerOptions().position(hollywood).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hollywood, 17));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "위성지도");
        menu.add(0, 2, 0, "일반지도");
        menu.add(0, 3, 0, "통화기록");
        SubMenu sMenu = menu.addSubMenu("즐겨찾기 >> ");
        sMenu.add(0, 4, 0, "비트교육센터");
        sMenu.add(0, 5, 0, "집");
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
            case 2:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case 3:
                // TODO : 통화 기록 뷰 코딩
                Intent callsIntent = new Intent(getApplicationContext(),Calls.class);
                startActivity(callsIntent);
                break;
            case 4:
                mMap.addMarker(new MarkerOptions().position(bitLatLng).title("비트교육센터"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bitLatLng, 16));
                break;
            case 5:
                mMap.addMarker(new MarkerOptions().position(homeLatLng).title("집"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(homeLatLng, 16));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
