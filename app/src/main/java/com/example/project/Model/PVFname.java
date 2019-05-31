package com.example.project.Model;

import java.util.ArrayList;

public class PVFname {

    private String name = "";
    private ArrayList<Brand> brands;
    private char indicator;


    public PVFname(String name, ArrayList<Brand> brands, char indicator) {
        this.brands = brands;
        this.name = name;
        this.indicator = indicator;
    }

    public PVFname(String name, char pvfType){
        this.name = name;
        this.indicator = pvfType;
    }


    public ArrayList<Brand> getBrands() {
        return brands;
    }

    public void addBrand(Brand brand) {
        brands.add(brand);
    }

    public char getIndicator() {
        return indicator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
