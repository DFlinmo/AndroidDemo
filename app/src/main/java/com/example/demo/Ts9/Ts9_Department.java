package com.example.demo.Ts9;

public class Ts9_Department {
    private int deptid;
    private String depttype;
    private String deptname;
    private String deptcost;

    public Ts9_Department(Integer deptid, String depttype, String deptname, String deptcost) {
        this.deptid=deptid;
        this.depttype=depttype;
        this.deptname=deptname;
        this.deptcost=deptcost;
    }

    public String getDepttype() {
        return depttype;
    }

    public void setDepttype(String depttype) {
        this.depttype = depttype;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDeptcost() {
        return deptcost;
    }

    public void setDeptcost(String deptcost) {
        this.deptcost = deptcost;
    }
}
