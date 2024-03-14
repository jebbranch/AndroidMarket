package rv.clockworks.androidmarket;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rv.clockworks.androidmarket.until.Data;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Button btn = null;
    TextView mian = null;
    TextView name = null;
    TextView id = null;
    TextView i_url = null;
    TextView desc = null;
    TextView type = null;
    TextView version = null;
    TextView dev = null;
    Button refresh = null;

    private void setDataToTextView(JSONObject json) {
        Gson gson = new Gson();
        Data data = gson.fromJson(json.toString(), Data.class);

        id.setText(data.id);
        name.setText(data.name);
        i_url.setText(data.i_url);
        desc.setText(data.desc);
        type.setText(data.type);
        version.setText(data.version);
        dev.setText(data.dev);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.about);
        btn.setOnClickListener(new About());
        mian = findViewById(R.id.mian);
        refresh = findViewById(R.id.refresh);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://api.hxzbaka.top/home").build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
                Log.e(TAG, "onFailure: ");
                runOnUiThread(() -> mian.setText("Failed to load content"));
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                assert response.body() != null;
                Log.e(TAG, "onResponse: " + response.body().string());
                String json = response.body().string();
                try {
                    setDataToTextView(new JSONObject(json));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }


            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                }
            }
        }).start();


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