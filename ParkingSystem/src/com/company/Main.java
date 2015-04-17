package com.company;

/**
 * Created by chandan.marathe on 4/8/2015.
 */
public class Main {

    public static void main(String[] args) {

        Command command=Command.getInstance();
        Car car;
        String[] colors = new String[]{"Green","Red","Blue","Orange"};
        for(int index =1 ;index<=100;index++){
            car = new Car();
            car.setRegistrationNumber(String.valueOf(index));
            car.setColor(colors[index%colors.length]);
            command.park(car);
        }
        car = new Car();
        car.setRegistrationNumber(String.valueOf(5));
        command.exit(car);
        car =new Car();
        car.setRegistrationNumber("101");
        car.setColor("Grey");
        command.park(car);
        command.getParkingLotNumbersOfColor("Green");
        command.getParkingSlotNumber("101");
        command.getRegistrationNumbersOfColor("Green");
    }
}
