    package com.example.study;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.fragment.app.Fragment;

    import android.app.FragmentManager;
    import android.os.Bundle;

    import com.google.android.gms.maps.CameraUpdateFactory;
    import com.google.android.gms.maps.GoogleMap;
    import com.google.android.gms.maps.MapFragment;
    import com.google.android.gms.maps.OnMapReadyCallback;
    import com.google.android.gms.maps.model.LatLng;
    import com.google.android.gms.maps.model.MarkerOptions;


    public class MainActivity extends AppCompatActivity {

        private FragmentManager fragmentManager;
        private MapFragment mapFragment;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            fragmentManager = getFragmentManager();
            mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.google_map);
            mapFragment.getMapAsync(this);
        }

        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng location = new LatLng(37.485284, 126.901451); // 구로디지털단지역 위치
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.title("구로디지털단지역");
            markerOptions.snippet("전철역");
            markerOptions.position(location);
            googleMap.addMarker(markerOptions);

//        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 16));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 16));

        }
    }
