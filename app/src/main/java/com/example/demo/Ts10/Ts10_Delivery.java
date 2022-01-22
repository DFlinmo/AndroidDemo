package com.example.demo.Ts10;

public class Ts10_Delivery {
    private String name;
    private String waybillNumber;
    private String pickupCode;
    private String telephone;

    public Ts10_Delivery(String name, String waybillNumber, String pickupCode, String telephone) {
        this.name = name;
        this.waybillNumber = waybillNumber;
        this.pickupCode = pickupCode;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWaybillNumber() {
        return waybillNumber;
    }

    public void setWaybillNumber(String waybillNumber) {
        this.waybillNumber = waybillNumber;
    }

    public String getPickupCode() {
        return pickupCode;
    }

    public void setPickupCode(String pickupCode) {
        this.pickupCode = pickupCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
