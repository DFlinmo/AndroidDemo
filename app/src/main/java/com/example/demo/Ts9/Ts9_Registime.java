package com.example.demo.Ts9;

public class Ts9_Registime {
    private String deptname;
    private String depttime;
    private String depttype;

    public Ts9_Registime(String deptname, String depttime) {
        this.deptname = deptname;
        this.depttime = depttime;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDepttime() {
        return depttime;
    }

    public void setDepttime(String depttime) {
        this.depttime = depttime;
    }

    public String getDepttype() {
        return depttype;
    }

    public void setDepttype(String depttype) {
        this.depttype = depttype;
    }
}
