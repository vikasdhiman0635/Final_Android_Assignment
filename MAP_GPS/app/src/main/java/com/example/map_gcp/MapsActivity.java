package com.example.map_gcp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    final static int PERMISSION_ALL = 1;
    final static String[] PERMISSIONS = {Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};
    private GoogleMap mMap;
    MarkerOptions mo;
    Marker marker;
    //    LatLng mycoordinates;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
//        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
//        mo = new MarkerOptions().position(new LatLng(0, 0)).title("My Current Location");
//        if (Build.VERSION.SDK_INT >= 23 && !isPermissionGranted()) {
//            requestPermissions(PERMISSIONS, PERMISSION_ALL);
//        } else requestlocation();
//        if (!isLocationEnabled())
//            showAlert(1);
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
//        marker = mMap.addMarker(mo);
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(29.536537, 76.969283);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

//    @Override
//    public void onLocationChanged(Location location) {
//
//        LatLng mycoordinates = new LatLng(location.getLatitude(), location.getLongitude());
//        marker.setPosition(mycoordinates);
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(mycoordinates));
//
//    }
//
//    @Override
//    public void onStatusChanged(String provider, int status, Bundle extras) {
//
//    }
//
//    @Override
//    public void onProviderEnabled(@NonNull String provider) {
//
//    }
//
//    @Override
//    public void onProviderDisabled(@NonNull String provider) {
//
//    }
//
//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//
//    }
//
//    //    @SuppressLint("MissingPermission")
//    private void requestlocation() {
//        Criteria criteria = new Criteria();
//        criteria.setAccuracy(Criteria.ACCURACY_FINE);
//        criteria.setPowerRequirement(Criteria.POWER_HIGH);
//        String provider = locationManager.getBestProvider(criteria, true);
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        locationManager.requestLocationUpdates(provider, 10000, 10, this);
//    }
//
//    private boolean isLocationEnabled()
//    {
//        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.M)
//    private boolean isPermissionGranted()
//    {
//        if(checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)== PackageManager.PERMISSION_GRANTED || checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED)
//        {
//            Log.v("mylog","Permission is granted");
//            return true;
//        }
//        else
//        {
//            Log.v("myLog", "Permission not granted");
//            return false;
//        }
//    }
//
//    private void showAlert(final int status)
//    {
//        String message, title, btnText;
//        if(status==1)
//        {
//            message="Your Location Setting is set to 'OFF',\nPlease Enable Location to use this app";
//            title= "Enable Location";
//            btnText="Location Setting";
//        }
//        else{
//            message="Please allow this app to access Location!";
//            title= "Permission access";
//            btnText="Grant";
//        }
////        final AlertDialog.Builder dialog= new AlertDialog.Builder(this);
////        dialog.setCancelable(false);
////        dialog.setTitle(title)
////                .setMessage(message)
////                .setPositiveButton(btnText, onClick(paramDialogInterface))
////        dialog.show();
//    }
}