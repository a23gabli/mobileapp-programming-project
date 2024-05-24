package com.example.project;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("WeakerAccess")
public class RecyclerViewItem {

    private String ID;
    @SerializedName("name")
    private String name;
    @SerializedName("company")

    private String company;
    @SerializedName("cost")
    private int cost;
    @SerializedName("auxdata")
    private double auxdata;

    public RecyclerViewItem(String ID, String name, String company, int cost, double auxdata) {
        this.ID = ID;
        this.name = name;
        this.company = company;
        this.cost = cost;
        this.auxdata = auxdata;
    }

    // Getters and setters for each field
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public double getAuxdata() {
        return auxdata;
    }

    public void setAuxdata(double auxdata) {
        this.auxdata = auxdata;
    }
}
