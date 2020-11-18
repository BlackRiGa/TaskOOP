package com.mycompany.kurs;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.mycompany.kurs.Type.PLUMBING;
import static org.junit.Assert.*;

public class BathroomTest {

    @org.junit.Test
    public void addTube() throws Exception {
        List<Tube> tubes1=new ArrayList();
        Tube tube = new Tube("f", (new TubeBuilder()).changeLength(1).changeDiameter(1).changeType(PLUMBING));
        tubes1.add(tube);
        Bathroom bathroom=new Bathroom();
        bathroom.addTube("f",1,1,PLUMBING);
        assertEquals(tubes1,bathroom);
    }

    @org.junit.Test
    public void searchTube() {
    }

    @org.junit.Test
    public void deleteTube() {
    }

    @org.junit.Test
    public void addFitting() {
    }

    @org.junit.Test
    public void searchFitting() {
    }

    @org.junit.Test
    public void deleteFitting() {
    }

    @org.junit.Test
    public void addWaterConsumer() {
    }

    @org.junit.Test
    public void searchWaterConsumer() {
    }

    @org.junit.Test
    public void deleteWaterConsumer() {
    }

    @org.junit.Test
    public void addWaterSource() {
    }

    @org.junit.Test
    public void searchWaterSource() {
    }

    @org.junit.Test
    public void deleteWaterSource() {
    }

    @org.junit.Test
    public void addDrain() {
    }

    @org.junit.Test
    public void searchDrain() {
    }

    @org.junit.Test
    public void deleteDrain() {
    }

    @org.junit.Test
    public void savePlan() {
    }

    @org.junit.Test
    public void loadPlan() {
    }
}