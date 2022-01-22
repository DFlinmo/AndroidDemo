package com.example.demo.Ts9;

public class Ts9_hospital {
    private String hspimg;
    private String hspname;
    private String hspstar;

    public Ts9_hospital(String hspimg, String hspname, String hspstar) {
        this.hspimg = hspimg;
        this.hspname = hspname;
        this.hspstar = hspstar;
    }


    public String getHspimg() {
        return hspimg;
    }

    public void setHspimg(String hspimg) {
        this.hspimg = hspimg;
    }

    public String getHspname() {
        return hspname;
    }

    public void setHspname(String hspname) {
        this.hspname = hspname;
    }

    public String getHspstar() {
        return hspstar;
    }

    public void setHspstar(String hspstar) {
        this.hspstar = hspstar;
    }
}
