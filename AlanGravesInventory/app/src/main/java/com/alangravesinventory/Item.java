package com.alangravesinventory;

public class Item {
    public String name;
    int count;

    public Item(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return name;
    }
}