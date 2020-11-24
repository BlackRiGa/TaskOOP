package com.mycompany.kurs;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.mycompany.kurs.Type.PLUMBING;

public class BathroomTest {
    @org.junit.Test
    public void addTube() throws Exception {
        Bathroom bathroom=new Bathroom();
        bathroom.addTube("f",1,1,PLUMBING);
        Assert.assertNotNull(bathroom.getTube(0));
    }
    @org.junit.Test
    public void getTube() throws Exception {
        Bathroom bathroom=new Bathroom();
        bathroom.addTube("z",1,1,PLUMBING);
        Assert.assertNotNull(bathroom.getTube("z"));
    }
    @org.junit.Test
    public void deleteTube() throws Exception {
        int z=1;
        Bathroom bathroom=new Bathroom();
        bathroom.addTube("f",1,1,PLUMBING);
        bathroom.deleteTube("f");
         if (bathroom.tubeisEmpty()){
             z=0;
         }
         Assert.assertEquals(0,z);
    }
    @org.junit.Test
    public void addFiting() throws Exception {
        Bathroom bathroom=new Bathroom();
        bathroom.addFitting("f",1,1,PLUMBING);
        Assert.assertNotNull(bathroom);
    }
    @org.junit.Test
    public void deleteFitting() throws Exception {
        int z=1;
        Bathroom bathroom=new Bathroom();
        bathroom.addFitting("f",1,1,PLUMBING);
        bathroom.deleteTube("f");
        if (bathroom.tubeisEmpty()){
            z=0;
        }
        Assert.assertEquals(0,z);
    }
}