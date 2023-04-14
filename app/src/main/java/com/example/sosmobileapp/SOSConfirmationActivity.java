package com.example.sosmobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SOSConfirmationActivity extends AppCompatActivity {


        Button cancelSOSBtn;
        TextView textViewCountDown;
        int MY_PERMISSIONS_REQUEST_SEND_SMS=1;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sosconfirmation);

            cancelSOSBtn=findViewById(R.id.cancelSOSBtn);
            textViewCountDown=findViewById(R.id.textViewCountdown);

            //countdown timer for SOS confirmation
            CountDownTimer timer= new CountDownTimer(4000,1000) {
                @Override
                public void onTick(long l) {
                    textViewCountDown.setText(String.valueOf(l/1000));
                }

                //send sms after 3 seconds finsihed
                @Override
                public void onFinish() {
                    sendSMS();
                    Toast.makeText(SOSConfirmationActivity.this, "SOS sent !!", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(SOSConfirmationActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            };

            //start the countdown
            timer.start();








            cancelSOSBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    timer.cancel();
                    Intent intent=new Intent(SOSConfirmationActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            });


        }

        private void sendSMS(){

            if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},MY_PERMISSIONS_REQUEST_SEND_SMS);

            }

            else{
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("8076287723", null, "Umang HELP ME PLEASE", null, null);
            }


        }


}