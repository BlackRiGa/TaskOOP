package com.mycompany.kurs;


/**
 *
 * @author gorbushin_v_a
 */
public class Fitting extends Plumb{
    Type type;

    public Fitting(String name, int inputs, int outputs, Type type){
        super(name);
        this.type = type;
    }
}
