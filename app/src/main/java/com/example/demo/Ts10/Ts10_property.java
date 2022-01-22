package com.example.demo.Ts10;

public class Ts10_property {
    private String divtel;
    private String divname;

    public Ts10_property(String divtel, String divname) {
        this.divtel = divtel;
        this.divname = divname;
    }

    public String getDivtel() {
        return divtel;
    }

    public void setDivtel(String divtel) {
        this.divtel = divtel;
    }

    public String getDivname() {
        return divname;
    }

    public void setDivname(String divname) {
        this.divname = divname;
    }
}
