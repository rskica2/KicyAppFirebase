package com.app.kicyappfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
//import com.google.firebase.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    public void runtimeEnableAutoInit() {
        // [START fcm_runtime_enable_auto_init]
        FirebaseMessaging.getInstance().setAutoInitEnabled(true);
        // [END fcm_runtime_enable_auto_init]
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button2 = (Button)findViewById(R.id.button2);
        // Register the onClick listener with the implementation above
        button2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                //DO SOMETHING! {RUN SOME FUNCTION ... DO CHECKS... ETC}
                finish();
            }
        });

        Button button1 = (Button)findViewById(R.id.button1);
// Register the onClick listener with the implementation above
        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                //DO SOMETHING! {RUN SOME FUNCTION ... DO CHECKS... ETC}

                // Get token
                // [START retrieve_current_token]
                FirebaseInstanceId.getInstance().getInstanceId()
                        .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                            @Override
                            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                                if (!task.isSuccessful()) {
                                    Log.w(TAG, "getInstanceId failed", task.getException());
                                    return;
                                }

                                // Get new Instance ID token
                                String token = task.getResult().getToken();

                                Log.d(TAG, token);

                                TextView tv1 = (TextView)findViewById(R.id.tv1);
                                tv1.setText(token);
                                EditText ed1 = (EditText)findViewById(R.id.editText1);
                                ed1.setText(token);
                                ed1.selectAll();

                            }
                        });
                // [END retrieve_current_token]



            }
        });


    }



}
