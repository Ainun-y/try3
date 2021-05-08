package com.example.try3.model;

import com.google.type.DayOfWeek;

import java.sql.Time;
import java.util.Date;

public class patientcondition {
    private String cId;
    private String cDay;
    private Date cDate;
    private Time cTime;
    private int ratingOedema;
    private int ratingWounds;
    private int ratingMuscle;
    private int ratingContracture;

    public patientcondition() {
    }

    public patientcondition(String cId, int ratingOedema, int ratingWounds, int ratingMuscle, int ratingContracture) {
        this.cId = cId;
       this.cDay = cDay;
      this.cDate = cDate;
     this.cTime = cTime;
        this.ratingOedema = ratingOedema;
       this.ratingWounds = ratingWounds;
        this.ratingMuscle = ratingMuscle;
        this.ratingContracture = ratingContracture;
    }

    public String getcId() {
        return cId;
    }

    public String getcDay() {
        return cDay;
    }

    public Date getcDate() {
        return cDate;
    }

    public Time getcTime() {
        return cTime;
    }


    public int getRatingOedema() {

        return ratingOedema;
    }

    public int getRatingWounds() {
        return ratingWounds;
    }

    public int getRatingMuscle() {
        return ratingMuscle;
    }

    public int getRatingContracture() {
        return ratingContracture;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public void setRatingOedema(int ratingOedema) {
        this.ratingOedema = ratingOedema;
    }
}
