package com.custom.hashmap;

class LinkedNode{
    int key;
    int value;
    LinkedNode next;
    public LinkedNode(int key,int value){
        this.key = key;
        this.value = value;
    }

    public int getKey(){
        return this.key;
    }

    public int getValue(){
        return this.value;
    }

    public void setKey(int key){
        this.key = key;
    }

    public void setValue(int value){
        this.value = value;
    }

    public LinkedNode getNext(){
        return this.next;
    }

    public void setNext(LinkedNode next){
        this.next = next;
    }

    public boolean put(int key,int value){
        LinkedNode root = this;
        if(root == null){
            return false;
        }
        while(root.getNext()!=null){
            if(root.getKey() == key)
                return false;
            root = root.getNext();
        }
        if(root.getKey() == key)
            return false;
        root.setNext(new LinkedNode(key,value));
        return true;
    }

    public int get(int key){
        LinkedNode root = this;
        if(root == null){
            return -1;
        }
        while(root!=null){
            if(root.getKey() == key){
                return root.getValue();
            }
            root = root.getNext();
        }
        return -1;
    }

    public void display(){
        LinkedNode root = this;
        if(root == null)
            return;
        while(root!=null){
            System.out.println("Key is "+root.getKey()+ "  :  Value is "+root.getValue());
            root = root.getNext();
        }
    }
}