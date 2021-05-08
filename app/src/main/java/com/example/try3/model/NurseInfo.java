package com.example.try3.model;

public class NurseInfo {
    private String nId;
    private String nName;
    private String nPhoneNum;
    private String nGender;
    private String nEmail;
    private String nUserName;
    private String nPassword;



    public NurseInfo() {
    }

    public NurseInfo(String nId, String nName, String nPhoneNum, String nGender, String nEmail, String nUserName, String nPassword) {
        this.nId = nId;
        this.nName = nName;
        this.nPhoneNum = nPhoneNum;
        this.nGender = nGender;
        this.nEmail = nEmail;
        this.nUserName= nUserName;
        this.nPassword = nPassword;

    }

    public void setnName(String nName) {
        this.nName = nName;
    }

    public void setnPassword(String nPassword) {
        this.nPassword = nPassword;
    }

    public void setnId(String nId) {
        this.nId = nId;
    }

    public void setnPhoneNum(String nPhoneNum) {
        this.nPhoneNum = nPhoneNum;
    }

    public void setnGender(String nGender) {
        this.nGender = nGender;
    }

    public void setnEmail(String nEmail) {
        this.nEmail = nEmail;
    }

    public String getnId() {
        return nId;
    }

    public String getnName() {
        return nName;
    }

    public String getnPhoneNum() {
        return nPhoneNum;
    }

    public String getnGender() {
        return nGender;
    }

    public String getnEmail() {
        return nEmail;
    }

    public String getnPassword() {
        return nPassword;
    }

    public String getnUserName() {
        return nUserName;
    }

    public void setnUserName(String nUserName) {
        this.nUserName = nUserName;
    }
}
