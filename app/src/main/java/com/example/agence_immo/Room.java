package com.example.agence_immo;

import java.io.Serializable;

public class Room implements Serializable {
    private String type;
    private int level;
    private double length;
    private double width;

    public Room(String type, int level, double length, double width) {
        this.type = type;
        this.level = level;
        this.length = length;
        this.width = width;
    }

    public String getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
}