package com.custom.hashmap;

/**
 * Created by chndn on 8/7/2014.
 */
public class TestCustomHashMap {

    public static void main(String[] args) {
        CustomHashMap customHashMap = new CustomHashMap();
        customHashMap.put(0,5);
        customHashMap.put(10,15);
        customHashMap.put(2,20);
        customHashMap.put(5,45);
        customHashMap.put(5,45);
        customHashMap.display();
        System.out.println("The value of 5 is "+customHashMap.get(5));
        System.out.println("The value of 10 is "+customHashMap.get(10));
        System.out.println("The value of 100 is "+customHashMap.get(100));
        System.out.println("The counter is "+customHashMap.getCounter());

    }
}
