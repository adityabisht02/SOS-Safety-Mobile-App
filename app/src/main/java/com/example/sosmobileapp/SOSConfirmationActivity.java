package com.example.sosmobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class SOSConfirmationActivity extends AppCompatActivity {


    Button cancelSOSBtn;
    TextView textViewCountDown;
    int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
    String smsMessage = "Help me please !! My location - ";
    String addressresult="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sosconfirmation);

        cancelSOSBtn = findViewById(R.id.cancelSOSBtn);
        textViewCountDown = findViewById(R.id.textViewCountdown);

        //countdown timer for SOS confirmation
        CountDownTimer timer = new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long l) {
                textViewCountDown.setText(String.valueOf(l / 1000));
            }

            //send sms after 3 seconds finsihed
            @Override
            public void onFinish() {

                try {
                    getLocation();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


                sendSMS();
                Toast.makeText(SOSConfirmationActivity.this, "SOS sent !!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SOSConfirmationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        };

        //start the countdown
        timer.start();


        cancelSOSBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.cancel();
                Intent intent = new Intent(SOSConfirmationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    private void sendSMS() {

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);

        } else {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("+15555215556", null, smsMessage, null, null);
        }


    }

    private void getLocation() throws IOException {

// Get the location manager
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

// Check if location services are enabled
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {

            // Get the last known location
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            // Check if the location is not null
            if (location != null) {

                // Get the latitude and longitude
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                //use a geocoder to decode lat long to address
                Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());

                try {
                    List<Address> list = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                    if (list != null && list.size() > 0) {
                        Address address = list.get(0);
                        // sending back first address line and locality
                         addressresult = address.getAddressLine(0) + ", " + address.getLocality();
                    }
                } catch (IOException e) {

                }finally{

                    smsMessage=smsMessage+" location: "+latitude+" ,"+longitude+", "+addressresult;
                }
            }
        } else {
            // Location services are not enabled, prompt the user to enable them
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        }
        }


}