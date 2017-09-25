package com.lachlannewman.stormy;

/**
 * Created by Lachlan Newman on 25/09/2017.
 */

public class Forecast {
    private double latitude;
    private double longitude;

    public Forecast(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
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
}
