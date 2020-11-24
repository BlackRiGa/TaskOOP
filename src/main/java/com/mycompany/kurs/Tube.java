package com.mycompany.kurs;

public class Tube extends Plumb{
    private Type type;
    private int length;
    private int diameter;

    public Tube(String name, TubeBuilder builder) throws Exception{
        super(name);
        this.length = builder.length;
        this.diameter = builder.diameter;
        this.type = builder.type;
    }

    public Type getType() {
        return type;
    }

    public int getLength() {
        return length;
    }

    public int getDiameter() {
        return diameter;
    }
}
