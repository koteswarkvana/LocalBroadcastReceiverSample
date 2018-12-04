package com.koti.apple.localbroadcastreceiversample;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

// Followed link: https://stackoverflow.com/questions/8802157/how-to-use-localbroadcastmanager
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "SenderMainActivity";
    private Button btSendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btSendMessage = findViewById(R.id.bt_send_message);
        btSendMessage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_send_message:
                sendMessage();
                startActivity(new Intent(MainActivity.this, ReceiverActivity.class));
                break;

        }
    }

    // Send an Intent with an action named "custom-event-name". The Intent sent should
    // be received by the ReceiverActivity.
    private void sendMessage() {
        Log.d(TAG, "Broadcasting message");
        Intent intent = new Intent(Constants.CUSTOM_MESSGAE);
        // You can also include some extra data.
        intent.putExtra("message", "Hi eswar welcome !");
        LocalBroadcastManager.getInstance(MainActivity.this).sendBroadcast(intent);
    }
}
