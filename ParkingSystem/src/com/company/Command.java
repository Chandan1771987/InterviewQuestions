package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chandan.marathe on 4/6/2015.
 */

public class Command {
   private static Command _instance;
   private static RulesManager rulesManager = RulesManager.getInstance();

   private static Map<String,ArrayList<ParkingLot>> parkingLotsBelongingToColor = new HashMap<String, ArrayList<ParkingLot>>();
   private static Map<String,Integer> parkingLotHashMap = new HashMap<String, Integer>();

   public static Command  getInstance(){
       if(_instance!=null){
           return _instance;
       }
       _instance = new Command();
       return _instance;
   }

   public void  park(Car car){
       if(rulesManager.isFull()){
           System.out.println("Hello Chandan the parking lot is full. You wait until a car exits");
           return;
       }
       Integer parkingLotNumber = rulesManager.getNearestParkingLot();
       ParkingLot parkingLot = new ParkingLot(parkingLotNumber,car);
       String color = car.getColor();
       ArrayList<ParkingLot> parkingLots;
       if(parkingLotsBelongingToColor.containsKey(color)){
            parkingLots= parkingLotsBelongingToColor.get(color);
           parkingLots.add(parkingLot);
       }
       else{
           parkingLots = new ArrayList<ParkingLot>();
           parkingLots.add(parkingLot);
       }
       parkingLotsBelongingToColor.put(color,parkingLots);
       parkingLotHashMap.put(parkingLot.getCar().getRegistrationNumber(),parkingLotNumber);
       rulesManager.park(parkingLotNumber);
       System.out.println("Car with reg number : "+car.getRegistrationNumber()+"is parked in the slot : "+parkingLotNumber);
   }

    public void exit(Car car){
        if(parkingLotsBelongingToColor.containsKey(car.getColor())==false){
            System.out.println("Car with the color doesnt exist");
            return;
        }
        if(parkingLotHashMap.containsKey(car.getRegistrationNumber())==false){
            System.out.println("Car with the registration number is not parked so cannot exit ");
            return;
        }

        parkingLotsBelongingToColor.remove(car.getColor());
        int parkingLotNumber = parkingLotHashMap.remove(car.getRegistrationNumber());
        rulesManager.exit(parkingLotNumber);
        System.out.println("Car with reg number "+car.getRegistrationNumber()+" is exiting from the parking lot number "+parkingLotNumber);
    }

    private  ArrayList<ParkingLot> getAllParkedCarsOfColor(String color){
        ArrayList<ParkingLot> parkingLots  = new ArrayList<ParkingLot>();
        if(parkingLotsBelongingToColor.containsKey(color)) {
             parkingLots = parkingLotsBelongingToColor.get(color);
        }
        return parkingLots;
    }

    public ArrayList<ParkingLot> getRegistrationNumbersOfColor(String color){
            ArrayList<ParkingLot> parkingLots = getAllParkedCarsOfColor(color);
            for(ParkingLot parkingLot : parkingLots ){
                System.out.println(" The Car Number is "+parkingLot.getCar().getRegistrationNumber());
            }
        return parkingLots;
    }

    public  ArrayList<ParkingLot> getParkingLotNumbersOfColor(String color){
        ArrayList<ParkingLot> parkingLots = getAllParkedCarsOfColor(color);
        for(ParkingLot parkingLot : parkingLots ){
            System.out.println("The Parking Slot Number is "+parkingLot.getNumber());
        }
        return parkingLots;
    }

    public  int getParkingSlotNumber(String registrationNumber){
        int parkingSlotNumber;
        if(parkingLotHashMap.containsKey(registrationNumber)==false){
            return -1;
        }
        parkingSlotNumber = parkingLotHashMap.get(registrationNumber);
        System.out.println("The Parking Slot Number is "+parkingSlotNumber);
        return parkingSlotNumber;
    }
}
