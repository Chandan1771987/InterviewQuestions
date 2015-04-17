package com.custom.hashmap;

import com.custom.hashmap.LinkedNode;

/**
 * Created by chndn on 8/7/2014.
 */
public class CustomHashMap {

    private static int SIZE = 10;

    Object[] elements;

    private int counter = 0;

    public CustomHashMap(){
        elements = new Object[SIZE];
    }

    public int getSize(){
        return this.counter;
    }

    public Object get(int key){
        int hash = getHashCode(key);
        if(elements[hash]==null)
            return null;
        LinkedNode node = (LinkedNode)elements[hash];
        return node.get(key);
    }

    private int getHashCode(int key){
        return (key%SIZE);
    }

    public void put(int key,int value){
        int hash = getHashCode(key);
        if(elements[hash]==null){
            elements[hash] = new LinkedNode(key,value);
        }
        else{
            LinkedNode node = (LinkedNode)elements[hash];
            if(node.put(key,value)==false) {
                return;
            }
            elements[hash] = node;
        }
        counter++;
    }

    public int getCounter(){
        return this.counter;
    }


    public void display(){
        int index = 0;
        while(index<SIZE) {
            if (elements[index] != null) {
                LinkedNode node = (LinkedNode) elements[index];
                node.display();
            }
            index++;
        }
    }
}


