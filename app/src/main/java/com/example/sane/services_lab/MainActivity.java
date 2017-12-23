package com.example.sane.services_lab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private TextView complete;
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(Event event){
        Integer i= event.getMessage();
        complete.setText(i.toString().trim());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = (Button) findViewById(R.id.start);
        complete = (TextView) findViewById(R.id.complete);
        EventBus.getDefault().register(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MyIntentService.class);
                startService(intent);
            }
        });
    }
}
