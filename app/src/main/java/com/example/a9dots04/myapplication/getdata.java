package com.example.a9dots04.myapplication;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 9DOTS04 on 12/20/2016.
 */

public class getdata {
    @SerializedName("zipcode")
    private String zipcode;
    @SerializedName("status_code")
    private int status_code;
    @SerializedName("address")
    private String address;
    @SerializedName("lat")

    private Double lat;
    @SerializedName("response_charset")
    private String response_charset;
    @SerializedName("lng")
    private Double lng;

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }


    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}
