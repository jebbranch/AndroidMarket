package rv.clockworks.androidmarket;

import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import rv.clockworks.androidmarket.Service.KeepAliveService;

public class MainActivity extends AppCompatActivity {
    Button btn=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.about);
        btn.setOnClickListener(new About());
        startService(new Intent(this, KeepAliveService.class));
    }
    class About implements View.OnClickListener {
        @Override
        public void onClick(View v) {
         // TODO Auto-generated method stub
            Intent in = new Intent();
            in.setClass(MainActivity.this, AboutActivity.class);
         startActivity(in);
        }
   }
}