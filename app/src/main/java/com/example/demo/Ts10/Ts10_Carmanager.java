package com.example.demo.Ts10;

public class Ts10_Carmanager {
    private String carnum;
    private String parkingSpace;
    private String parkingCardNumber;
    private String ownerSName;
    private String ownersTel;
    private String residentName;
    private String address;

    public Ts10_Carmanager(String carnum, String parkingSpace, String parkingCardNumber, String ownerSName, String ownersTel, String residentName, String address) {
        this.carnum = carnum;
        this.parkingSpace = parkingSpace;
        this.parkingCardNumber = parkingCardNumber;
        this.ownerSName = ownerSName;
        this.ownersTel = ownersTel;
        this.residentName = residentName;
        this.address = address;
    }

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum;
    }

    public String getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(String parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public String getParkingCardNumber() {
        return parkingCardNumber;
    }

    public void setParkingCardNumber(String parkingCardNumber) {
        this.parkingCardNumber = parkingCardNumber;
    }

    public String getOwnerSName() {
        return ownerSName;
    }

    public void setOwnerSName(String ownerSName) {
        this.ownerSName = ownerSName;
    }

    public String getOwnersTel() {
        return ownersTel;
    }

    public void setOwnersTel(String ownersTel) {
        this.ownersTel = ownersTel;
    }

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
