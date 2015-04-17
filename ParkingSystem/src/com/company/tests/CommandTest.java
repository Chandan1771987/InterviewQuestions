package com.company.tests;

import com.company.Car;
import com.company.Command;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommandTest {

    Command command;

    private void initialize(){
        command = Command.getInstance();
        Car car;
        String[] colors = new String[]{"Green","Red","Blue","Orange"};
        for(int index =1 ;index<=100;index++){
            car = new Car();
            car.setRegistrationNumber(String.valueOf(index));
            car.setColor(colors[index%colors.length]);
            command.park(car);
        }
    }

    @Test
    public void testPark() throws Exception {
        initialize();
        Car car = new Car();
        car.setColor("White");
        car.setRegistrationNumber("101");
        command.park(car);
        assertEquals(0, command.getParkingLotNumbersOfColor("White").size());
        assertEquals(-1,command.getParkingSlotNumber("101"));
    }

    @Test
    public void testExit() throws Exception {
        initialize();
        assertEquals(1,command.getParkingSlotNumber("1"));
        Car car = new Car();
        car.setColor("Red");
        car.setRegistrationNumber("1");
        command.exit(car);
        assertEquals(-1,command.getParkingSlotNumber("1"));
    }

    @Test
    public void testGetRegistrationNumbersOfColor() throws Exception {
        initialize();
        assertEquals(0,command.getRegistrationNumbersOfColor("GreenWhite").size());
    }

    @Test
    public void testGetParkingLotNumbersOfColor() throws Exception {
        initialize();
        assertEquals(0,command.getParkingLotNumbersOfColor("GreenWhite").size());
    }

    @Test
    public void testGetParkingSlotNumber() throws Exception {
        initialize();
        assertEquals(-1,command.getParkingSlotNumber("200"));
    }
}