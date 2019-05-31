package com.example.project.Model;

public class Brand {

    public String brands = "";
    private double costs;


    public Brand(String brands, double costs) {
        this.brands = brands;
        this.costs = costs;
    }

    public Brand(){}

    public double getCosts() {
        return costs;
    }

    public String getItemName() {
        return brands;
    }

    public void setBrands(String brands) {
        this.brands = brands;
    }

    public void setCosts(double costs) {
        this.costs = costs;
    }
}
