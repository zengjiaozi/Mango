package com.richinfo.www.mango;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.richinfo.www.mylibrary.app.Mango;
import com.richinfo.www.mylibrary.loader.LoaderStyle;
import com.richinfo.www.mylibrary.net.RestClient;
import com.richinfo.www.mylibrary.net.callback.IError;
import com.richinfo.www.mylibrary.net.callback.IFailure;
import com.richinfo.www.mylibrary.net.callback.ISuccess;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(Mango.getApplicationContext(), "application 加载啦", Toast.LENGTH_SHORT).show();


        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test();
            }
        });

    }


    private void test() {
        RestClient.builder().url("ajax.php?a=fy&f=auto&t=auto&w=hello%20world").error(new IError() {
            @Override
            public void onError(int code, String msg) {
                Log.i("TAG", "onError" + msg);
            }
        }).loader(MainActivity.this, LoaderStyle.BallScaleRippleIndicator).
                success(new ISuccess() {
            @Override
            public void onSuccess(String response) {

                Gson gson = new Gson();
                Bean bean = gson.fromJson(response.toString(), Bean.class);
                Bean.ContentBean ontecnt = bean.getContent();
                Log.i("TAG", "response" + response.toString());
                Log.i("TAG", "ontecnt" + ontecnt.toString());
                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();

            }
        }).failure(new IFailure() {
            @Override
            public void onFailure() {

            }
        }).build().get();

    }
}
