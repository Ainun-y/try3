package com.example.try3.main;

import com.example.try3.model.patientcondition;

public class MonthSalesData{

    private String month;
    private int sales;

    public MonthSalesData(String month, int sales) {
        this.month = month;
        this.sales = sales;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
}
