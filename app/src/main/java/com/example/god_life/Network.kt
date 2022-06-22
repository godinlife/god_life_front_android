package com.example.god_life

import android.util.Log
import okhttp3.*
import okio.IOException

class Network {
    companion object{
        const val URL:String = "http://182.217.140.11:3000/"
        private var okHttpClient:OkHttpClient = OkHttpClient().newBuilder().addInterceptor(AuthInterceptor()).build()
        lateinit var token:String
    }

    fun login(id:String, pw:String, onResponse: (String)-> Unit){

        val request = Request.Builder()
            .url(URL + "user/login/")
            .post(
                FormBody.Builder()
                    .add("id","test")
                    .add("password","test")
                    .build())
            .build()


        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("asd fail", e.toString())
            }
            override fun onResponse(call: Call, response: Response) {
                val body = response.body!!.string()
                Log.d("asd login",body)
                onResponse(body)
            }
        })
    }
}

internal class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request();
        val response = chain.proceed(request);

        when (response.code) {
            400 -> {
                //Show Bad Request Error Message
            }
            401 -> {
//                request.newBuilder()
//                    .header("Authorization",)
                //Show UnauthorizedError Message
            }

            403 -> {
                //Show Forbidden Message
            }

            404 -> {
                //Show NotFound Message
            }

            // ... and so on

        }
        return response
    }
}