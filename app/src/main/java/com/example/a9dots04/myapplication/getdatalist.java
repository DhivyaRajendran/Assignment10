package com.example.a9dots04.myapplication;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by 9DOTS04 on 12/20/2016.
 */

public class getdatalist {
    @SerializedName("results")
    private ArrayList<getdata> NewInstallationlist = new ArrayList<>();
    @SerializedName("zipcode")
    private String zipcode;
    @SerializedName("status_code")
    private int status_code;
    @SerializedName("address")
    private String address;
    @SerializedName("lat")

    private String lat;
    @SerializedName("response_charset")
    private String response_charset;
    @SerializedName("lng")
    private String lng;

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
    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public ArrayList<getdata> getNewInstallationlist() {
        return NewInstallationlist;
    }


    public void setNewInstallationlist(ArrayList<getdata> trlist) {
        this.NewInstallationlist = trlist;
    }

    //Getters and setters
    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }
}
