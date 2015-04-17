package com.company;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by chandan.marathe on 4/6/2015.
 */
public class RulesManager {
    private static RulesManager _instance;

    private static int sizeOfParkingLot=100;
    private boolean isFull;

    private static TreeMap<Integer,ParkingLot> freeSlots = new TreeMap<Integer,ParkingLot>();

    private static void init(){
        ParkingLot parkingLot ;
        for (int i =1;i<=sizeOfParkingLot;i++){
            parkingLot = new ParkingLot();
            parkingLot.setNumber(i);
            freeSlots.put(i,parkingLot);
        }
    }

    public void exit(int slot){
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setNumber(slot);
        freeSlots.put(slot,parkingLot);
    }

    public void park(int i){
        if(freeSlots.size()>0) {
            freeSlots.remove(i);
        }
    }

    public int getSizeOfParkingLot() {
        return sizeOfParkingLot;
    }

    public Integer getNearestParkingLot(){
        return freeSlots.firstKey();
    }

    public void setSizeOfParkingLot(int sizeOfParkingLot) {
        this.sizeOfParkingLot = sizeOfParkingLot;
    }

    public boolean isFull() {
        return freeSlots.size()==0;
    }

    public static RulesManager getInstance() {
        if(_instance!=null)
            return _instance;
        _instance = new RulesManager();
        init();
        return _instance;
    }
}
