package com.example.demo.Ts8;

public class Ts8_panccy {
    private String area;
    private String score;
    private String money;
    private String date;
    private String handle;
    private String carid;

    public Ts8_panccy(String area, String score, String money, String date, String handle, String carid) {
        this.area = area;
        this.score = score;
        this.money = money;
        this.date = date;
        this.handle = handle;
        this.carid = carid;
    }



    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

}
