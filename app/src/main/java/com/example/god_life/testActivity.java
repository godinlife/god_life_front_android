package com.example.god_life;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class testActivity extends AppCompatActivity {

    public interface CallBack{
        public void getCallBack(String text);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        Toast.makeText(this, "faile : " + "a".toString(),Toast.LENGTH_LONG).show();


        findViewById(R.id.edttextEnter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestHTTP.GET(
                        ((EditText)findViewById(R.id.edttext)).getText().toString()
                );
            }
        });
    }

}

class TestHTTP{
    static String URL = "http://182.217.140.11:3000/";

    static void GET(String url){
        Request request = new Request.Builder()
                .url(URL + url)
                .get()
                .build();

        new OkHttpClient().newCall(request).enqueue(
                new Callback() {
                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {
                        System.out.println("faile : " + e.toString());
                    }

                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        System.out.println("success : " + response.body());
                    }
                }
        );

    }
    public void login(){
        Request request = new Request.Builder()
                .url(URL + "user/login/")
                .post(
                        new FormBody.Builder()
                                .add("id","test")
                                .add("password","test")
                                .build())
                .build();

        new OkHttpClient().newCall(request).enqueue(
                new Callback() {
                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {
                        System.out.println("faile : " + e.toString());
                    }

                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        System.out.println("success : " + response.body());

                    }
                }
        );
    }
}