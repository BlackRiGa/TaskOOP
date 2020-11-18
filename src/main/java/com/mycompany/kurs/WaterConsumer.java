package com.mycompany.kurs;

public class WaterConsumer extends Plumb{
    int length;
    int width;
    
    public WaterConsumer(String name, int length, int width) {
        super(name);
        this.length = length;
        this.width = width;
    }
}
