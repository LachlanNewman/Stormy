package com.lachlannewman.stormy;



import android.content.res.Resources;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Lachlan Newman on 25/09/2017.
 */

public class GetForecast {

    private static final String TAG = GetForecast.class.getSimpleName();

    private String apiKey;
    private double latitude;
    private double longitude;
    private OkHttpClient client;
    private String forecastUrl;

    public GetForecast(String apiKey, double latitude, double longitude) {
        this.apiKey = apiKey;
        this.latitude = latitude;
        this.longitude = longitude;
        client = new OkHttpClient();
        forecastUrl = "https://api.darksky.net/forecast/" + apiKey + "/" + latitude +"," + longitude;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getRequest(){
        String data = "";
        Request request = new Request.Builder()
                .url(forecastUrl)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try{
                    if(response.isSuccessful()){
                        Log.v(TAG,response.body().string());
                    }
                }
                catch (IOException e){
                    Log.e(TAG,"Exception caught:"+e);
                }
            }
        });

        return data;
    }
}
