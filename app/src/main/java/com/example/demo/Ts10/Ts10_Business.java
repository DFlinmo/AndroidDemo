package com.example.demo.Ts10;

public class Ts10_Business {
    int businessimg;
    String businessname;
    String advertising;

    public Ts10_Business(int businessimg, String businessname, String advertising) {
        this.businessimg = businessimg;
        this.businessname = businessname;
        this.advertising = advertising;
    }

    public int getBusinessimg() {
        return businessimg;
    }

    public void setBusinessimg(int businessimg) {
        this.businessimg = businessimg;
    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname;
    }

    public String getAdvertising() {
        return advertising;
    }

    public void setAdvertising(String advertising) {
        this.advertising = advertising;
    }
}
