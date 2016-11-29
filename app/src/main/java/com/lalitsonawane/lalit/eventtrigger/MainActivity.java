package com.lalitsonawane.lalit.eventtrigger;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String textMessage = "Intent text";
        final Button button = (Button) findViewById(R.id.button);
        final Button button1 = (Button) findViewById(R.id.mButton);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendLine(textMessage);
            }

        });
        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                capturePhoto();
            }
        });


    }

    public void sendLine(String textMessage) {

        Intent intent = new Intent(this, Intent_Action.class);
        intent.putExtra("pickup line", textMessage);
        startActivity(intent);

    }

    public void sendSecond(String textMessage) {

        Intent intent = new Intent(this, Intent_Action.class);
        intent.putExtra("second line text", textMessage);
        startActivity(intent);
    }

    public void capturePhoto() {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_MEDIA_SEARCH);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


}
