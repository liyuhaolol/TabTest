package spa.lyh.cn.tabtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity {
    Button small,middle,big;
    App app;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (App) getApplication();
        setContentView(R.layout.activity_setting);
        small = findViewById(R.id.small);
        middle = findViewById(R.id.middle);
        big = findViewById(R.id.big);

        small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.setFontSize(10);
                send();
            }
        });
        middle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.setFontSize(20);
                send();
            }
        });
        big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.setFontSize(30);
                send();
            }
        });
    }

    private void send(){
        Intent intent=new Intent();
        intent.setAction(getPackageName()+FontSizeReceiver.LAN_ACTION);
        sendBroadcast(intent);
    }
}
