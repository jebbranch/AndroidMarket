package rv.clockworks.androidmarket;

import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rv.clockworks.androidmarket.Service.KeepAliveService;

public class MainActivity extends AppCompatActivity {
    Button btn=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.about);
        btn.setOnClickListener(new About());
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://www.baidu.com").build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                //textView.setText("Failed to load content");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String html = response.body().string();
                //textView.setText(html);
            }
        });
        //startService(new Intent(this, KeepAliveService.class));
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