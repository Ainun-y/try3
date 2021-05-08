package com.example.try3.model;

public class PatientInfo {
    private String pId;
    private String pIC;
    private String pName;
    private String pPhoneNum;
    private String pAddress;
    private String pPoscode;
    private String pDistrict;
    private String pCountry;

    public PatientInfo() {
    }

    public PatientInfo(String pId, String pIC, String pName, String pPhoneNum, String pAddress, String pPoscode, String pDistrict, String pCountry) {
        this.pId = pId;
        this.pIC = pIC;
        this.pName = pName;
        this.pPhoneNum = pPhoneNum;
        this.pAddress = pAddress;
        this.pPoscode = pPoscode;
        this.pDistrict = pDistrict;
        this.pCountry = pCountry;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public void setpIC(String pIC) {
        this.pIC = pIC;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public void setpPhoneNum(String pPhoneNum) {
        this.pPhoneNum = pPhoneNum;
    }

    public void setpAddress(String pAddress) {
        this.pAddress = pAddress;
    }

    public void setpPoscode(String pPoscode) {
        this.pPoscode = pPoscode;
    }

    public void setpDistrict(String pDistrict) {
        this.pDistrict = pDistrict;
    }

    public void setpCountry(String pCountry) {
        this.pCountry = pCountry;
    }

    public String getpId() {
        return pId;
    }

    public String getpIC() {
        return pIC;
    }

    public String getpName() {
        return pName;
    }

    public String getpPhoneNum() {
        return pPhoneNum;
    }

    public String getpAddress() {
        return pAddress;
    }

    public String getpPoscode() {
        return pPoscode;
    }

    public String getpDistrict() {
        return pDistrict;
    }

    public String getpCountry() {
        return pCountry;
    }
}
