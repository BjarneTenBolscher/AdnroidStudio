package com.example.project.Model;

import android.content.Context;

import com.example.project.R;

import java.util.ArrayList;

public class DataProvider {

    private static DataProvider dataProvider;

    private String[] appleBrands = {"Pink Lady", "Kanzi", "Jumami", "Granny Smith", "Golden Delicious"};
    private double[] appleCosts = {3.51, 2.69, 3.29, 2.98, 2.98};

    private String[] carrotbrand = {"Kroger", "Bolthouse", "Grimmway", "Gedney", "Ambrosia", "Roland"};
    private double[] carrotcosts = {2.22, 2.14, 2.49, 2.09, 2.38, 2.48};

    private String[] sweetbrand = {"Alexia", "Terra", "Green giant", "Bruce"};
    private double[] sweetcosts = {3.51, 3.69, 3.29, 3.98, 3.98};

    public static ArrayList<PVFname> pvf = new ArrayList<>();
    public static ArrayList<Brand> fruitBrands = new ArrayList<>();
    public static ArrayList<Brand> potatoBrands = new ArrayList<>();
    public static ArrayList<Brand> vegetableBrands = new ArrayList<>();
    private Context context;

    public DataProvider(Context context) {
        this.context = context;
        run();
    }

    public static DataProvider getInstance(Context context) {
        if (dataProvider == null) {
            dataProvider = new DataProvider(context);
        }
        return dataProvider;
    }

    public ArrayList<PVFname> run() {
        String[] someFruits = context.getResources().getStringArray(R.array.fruits);
        //With this line of code i get the String array from the String.xml file and
        //put it in the string array
        for (int i = 0; i < someFruits.length; i++) {
            for (int j = 0; j < appleBrands.length; j++) {
                fruitBrands.add(new Brand(appleBrands[j], appleCosts[j]));
            }
            pvf.add(new PVFname(someFruits[i], fruitBrands, 'F'));
        }
        String[] somePotatos = context.getResources().getStringArray(R.array.potatos);
        for (int i = 0; i < somePotatos.length; i++) {
            for (int j = 0; j < sweetbrand.length; j++) {
                potatoBrands.add(new Brand(sweetbrand[j], sweetcosts[j]));
            }
            pvf.add(new PVFname(somePotatos[i], potatoBrands, 'P'));
        }
        String[] someVegetables = context.getResources().getStringArray(R.array.vegetables);
        for (int i = 0; i < someVegetables.length; i++) {
            for (int j = 0; j < carrotbrand.length; j++) {
                vegetableBrands.add(new Brand(carrotbrand[j], carrotcosts[j]));
            }
            pvf.add(new PVFname(someVegetables[i], vegetableBrands, 'V'));
        }
        return pvf;
    }

    public ArrayList<PVFname> getPVF() {
        return pvf;
    }

    public static void addType(String type, String pvfType){
        char indicator = pvfType.toUpperCase().charAt(0);
        pvf.add(new PVFname(type, indicator));
    }
    /*in this method we get the type and the pvfType from the class where this method got called.
     It makes an indicator form type char and fill it with the firsts letter of the pvfType. then
     add the type and indicator to the pvf list*/

    public static void addBrand(String name, double costs, String chosen, char indicator) {
        for (int i = 0; i < pvf.size(); i++) {
            if (indicator == 'V') {
                if (pvf.get(i).getName().equals(chosen)) {
                    pvf.get(i).addBrand(new Brand(name, costs));
                    vegetableBrands = pvf.get(i).getBrands();
                    break;
                }
            } else if (indicator == 'P') {
                if (pvf.get(i).getName().equals(chosen)) {
                    pvf.get(i).addBrand(new Brand(name, costs));
                    potatoBrands = pvf.get(i).getBrands();
                    break;
                }
            } else if (indicator == 'F') {
                if (pvf.get(i).getName().equals(chosen)) {
                    pvf.get(i).addBrand(new Brand(name, costs));
                    fruitBrands = pvf.get(i).getBrands();
                    break;
                }
            }
        }

    }
    /*This method goes into three loops which essentially do the same thing. It goes int o a loop
    for the size of the size of the pvf list then check if the indicator which we got from the class
    where this method got called along with the name of the new brand and the costs and the type
    where it is under. It then checks the indicator if it corresponds with either F for fruit, V for
    vegetable or P for potato. When the indicator corresponds with either one of those then it
    will check if the name of the type corresponds with the chosen type. If it corresponds then it
    will got to the addBrand method with the name and costs set inside of the brand class. then it
    will add those brands to the fruitBrands list then it will break the loop seeing as there is
    only a single thing that needs to be added*/

    public static ArrayList<Brand> getBrands(char indicator) {
        if (indicator == 'F') {
            return fruitBrands;
        } else if (indicator == 'V') {
            return vegetableBrands;
        } else {
            return potatoBrands;
        }
    }

}
