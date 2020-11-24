package com.mycompany.kurs;

import java.io.Serializable;

public class Plumb implements Serializable{
    private String name;
    
    public Plumb(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
