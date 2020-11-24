package com.mycompany.kurs;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;


import static com.mycompany.kurs.Type.PLUMBING;
import static org.junit.Assert.*;

public class BathroomTest {

    @org.junit.Test
    public void addTube() throws Exception {
        Bathroom bathroom=new Bathroom();
        bathroom.addTube("f",1,1,PLUMBING);
        Assert.assertNotNull(bathroom);
    }

    @org.junit.Test
    public void searchTube() throws Exception {
        Bathroom bathroom=new Bathroom();
        bathroom.addTube("z",1,1,PLUMBING);
        bathroom.searchTube("z");

    }

    @org.junit.Test
    public void deleteTube() throws Exception {
        Bathroom bathroom=new Bathroom();
        bathroom.addTube("f",1,1,PLUMBING);
        bathroom.deleteTube("f");

    }
}