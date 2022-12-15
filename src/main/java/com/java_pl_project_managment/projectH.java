package com.java_pl_project_managment;


public class projectH {
    // I would show the Date as a String
    private String date;
    private String description;
    private String pmEmail;
    private String tlEmail;
    private String proName;
    private String state;
    private Double progress;

    public projectH(String date, String description, String pmEmail, String tlEmail, String proName, String state, double progress) {
        this.date = date;
        this.description = description;
        this.pmEmail = pmEmail;
        this.tlEmail = tlEmail;
        this.proName = proName;
        this.state = state;
        this.progress = progress;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPmEmail() {
        return pmEmail;
    }

    public void setPmEmail(String pmEmail) {
        this.pmEmail = pmEmail;
    }

    public String getTlEmail() {
        return tlEmail;
    }

    public void setTlEmail(String tlEmail) {
        this.tlEmail = tlEmail;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }
}
