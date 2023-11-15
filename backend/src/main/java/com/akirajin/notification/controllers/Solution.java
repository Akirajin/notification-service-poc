package com.akirajin.notification.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class Car {
    protected Boolean isSedan;
    protected String seats;

    public Car(Boolean isSedan, String seats) {
        this.isSedan = isSedan;
        this.seats = seats;
    }

    public Boolean getIsSedan() {
        return isSedan;
    }

    public String getSeats() {
        return seats;
    }

    public abstract String getMiliage();


    public void printCar(String carName) {
        System.out.print(String.format("%s %s", getMiliage(), "kmpl"));
    }
}

class WagonR extends Car {

    private final String miliage;

    public WagonR(int miliage) {
        super(false, "4");
        this.miliage = String.valueOf(miliage);
    }

    @Override
    public String getMiliage() {
        return miliage;
    }


}
class HondaCity extends Car {

    private final String miliage;

    public HondaCity(int miliage) {
        super(true, "4");
        this.miliage = String.valueOf(miliage);
    }

    @Override
    public String getMiliage() {
        return miliage;
    }
}

class InnovaCrysta extends Car {

    private final String miliage;

    public InnovaCrysta(int miliage) {
        super(false, "6");
        this.miliage = String.valueOf(miliage);
    }

    @Override
    public String getMiliage() {
        return miliage;
    }
}


public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int carType = Integer.parseInt(bufferedReader.readLine().trim());
        int carMileage = Integer.parseInt(bufferedReader.readLine().trim());

        if (carType == 0){
            Car wagonR = new WagonR(carMileage);
            wagonR.printCar("WagonR");
        }

        if(carType == 1){
            Car hondaCity = new HondaCity(carMileage);
            hondaCity.printCar("HondaCity");
        }

        if(carType == 2){
            Car innovaCrysta = new InnovaCrysta(carMileage);
            innovaCrysta.printCar("InnovaCrysta");
        }
    }
}
