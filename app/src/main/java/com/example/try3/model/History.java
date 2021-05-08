package com.example.try3.model;

public class History {
   private String hId;
    //private String hDate;
    private String hDetails;
    private String hMeasles;
   private String hMumps;
    private String chRubella;
    private String chChickenPox;
    private String chPolio;
    private String chRheumaticFever;
    private String iTetanus;
    private String iInfluenza;
    private String iChickenPox;
    private String iHepatitis;
    private String iPneumonia;
    private String iMMR;

    public History() {
    }

    public History(String hId, String hDetails, String hMeasles, String hMumps, String chRubella, String chChickenPox, String chPolio, String chRheumaticFever, String iTetanus, String iInfluenza, String iChickenPox, String iHepatitis, String iPneumonia, String iMMR) {
        this.hId = hId;
        this.hDetails = hDetails;
        this.hMeasles = hMeasles;
        this.hMumps = hMumps;
        this.chRubella = chRubella;
        this.chChickenPox = chChickenPox;
        this.chPolio = chPolio;
        this.chRheumaticFever = chRheumaticFever;
        this.iTetanus = iTetanus;
        this.iInfluenza = iInfluenza;
        this.iChickenPox = iChickenPox;
        this.iHepatitis = iHepatitis;
        this.iPneumonia = iPneumonia;
        this.iMMR = iMMR;
    }

    public String gethId() {
        return hId;
    }
/*
    public String gethDate() {
        return hDate;
    }*/

    public String gethMeasles() {
        return hMeasles;
    }



    public String gethMumps() {
        return hMumps;
    }

   public String getChRubella() {
        return chRubella;
    }

    public String getChChickenPox() {
        return chChickenPox;
    }

    public String getChPolio() {
        return chPolio;
    }

    public String getChRheumaticFever() {
        return chRheumaticFever;
    }

    public String getiTetanus() {
        return iTetanus;
    }

    public String getiInfluenza() {
        return iInfluenza;
    }

    public String getiChickenPox() {
        return iChickenPox;
    }

    public String getiHepatitis() {
        return iHepatitis;
    }

    public String getiPneumonia() {
        return iPneumonia;
    }

    public String getiMMR() {
        return iMMR;
    }

    public String gethDetails() {
        return hDetails;
    }


/*  public void sethId(String hId) {
        this.hId = hId;
    }

    public void sethDate(String hDate) {
        this.hDate = hDate;
    }
*/
    public void sethMeasles(String hMeasles) {
        this.hMeasles = hMeasles;
    }

   public void sethMumps(String hMumps) {
        this.hMumps = hMumps;
    }

   public void setChRubella(String chRubella) {
        this.chRubella = chRubella;
    }

    public void setChChickenPox(String chChickenPox) {
        this.chChickenPox = chChickenPox;
    }

    public void setChPolio(String chPolio) {
        this.chPolio = chPolio;
    }

    public void setChRheumaticFever(String chRheumaticFever) {
        this.chRheumaticFever = chRheumaticFever;
    }

    public void setiTetanus(String iTetanus) {
        this.iTetanus = iTetanus;
    }

    public void setiInfluenza(String iInfluenza) {
        this.iInfluenza = iInfluenza;
    }

    public void setiChickenPox(String iChickenPox) {
        this.iChickenPox = iChickenPox;
    }

    public void setiHepatitis(String iHepatitis) {
        this.iHepatitis = iHepatitis;
    }

    public void setiPneumonia(String iPneumonia) {
        this.iPneumonia = iPneumonia;
    }

    public void setiMMR(String iMMR) {
        this.iMMR = iMMR;
    }
}
