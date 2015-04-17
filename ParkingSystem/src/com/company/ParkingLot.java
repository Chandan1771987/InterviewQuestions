package com.company;

/**
 * Created by chandan.marathe on 4/6/2015.
 */
public class ParkingLot {
    int number;
    Car car;

    public ParkingLot(){

    }

    public ParkingLot(int number, Car car) {
        this.number = number;
        this.car = car;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
