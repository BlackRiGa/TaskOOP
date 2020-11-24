package com.mycompany.kurs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Bathroom implements Serializable{
    
    private static Bathroom instance;

    List<Tube> tubes;
    List<Fitting> fittings;
    List<WaterConsumer> waterConsumers;
    List<WaterSource> waterSources;
    List<Drain> drains;
    Links links;

    private static final long serialVersionUID = 1L;
    
    public Bathroom() {
        this.tubes = new ArrayList<>();
        this.fittings = new ArrayList<>();
        this.waterConsumers = new ArrayList<>();
        this.waterSources = new ArrayList<>();
        this.drains = new ArrayList<>();
        this.links = new Links();
    }
    
    public static Bathroom getInstance(){
        if(instance == null){
            instance = new Bathroom();
        }
        return instance;
    }

    public void addTube(String name, int length, int diameter, Type type) throws Exception {
            Tube tube = new Tube(name, (new TubeBuilder()).changeLength(length).changeDiameter(diameter).changeType(type));
            tubes.add(tube);
    }

    public Tube getTube(int index){
        return tubes.get(index);
    }
    public boolean tubeisEmpty(){
        return tubes.isEmpty();
    }
    
    public Tube getTube(String name) throws Exception {
        for (Tube tube : tubes) {
            if (tube.getName()==name) return tube;
        }
        return null;
        //return tubes.stream().findFirst().filter(i -> i.getName().equals(name)).orElseThrow(() -> new Exception("No such pipe"));
        
    }

    public void deleteTube(String name) throws Exception {
        tubes.remove(this.getTube(name));
    }

    public void addFitting(String name, int inputs, int outputs, Type type) throws Exception {
        if (type.equals(Type.PLUMBING)) {
            Fitting fitting = new Fitting(name, inputs, outputs, Type.PLUMBING);
            fittings.add(fitting);
        } else {
            if (type.equals(Type.SEWER)) {
                Fitting fitting = new Fitting(name, inputs, outputs, Type.SEWER);
                fittings.add(fitting);
            }
        }
    }

    public Fitting searchFitting(String name) throws Exception {
        return fittings.stream().findFirst().filter(i -> i.getName().equals(name)).orElseThrow(() -> new Exception("No such fitting"));
    }

    public void deleteFitting(String name) throws Exception {//проверить что будет с соседними трубами
        fittings.remove(this.searchFitting(name));
    }

    public void addWaterConsumer(String name, int length, int diameter) throws Exception {
        WaterConsumer tube = new WaterConsumer(name, length, diameter);
        waterConsumers.add(tube);
    }

    public WaterConsumer searchWaterConsumer(String name) throws Exception {
        return waterConsumers.stream().findFirst().filter(i -> i.getName().equals(name)).orElseThrow(() -> new Exception("No such water consumer"));
    }

    public void deleteWaterConsumer(String name) throws Exception {
        waterConsumers.remove(this.searchWaterConsumer(name));

    }

    public void addWaterSource(String name) throws Exception {
        WaterSource wsource = new WaterSource(name);
        waterSources.add(wsource);
    }
    
    public WaterSource searchWaterSource(String name) throws Exception {
        return waterSources.stream().filter(i -> i.getName().equals(name)).findFirst().orElseThrow(() -> new Exception("No such water source"));
    }
    
    public void deleteWaterSource(String name) throws Exception {
        waterSources.remove(this.searchWaterSource(name));

    }
    
    public void addDrain(String name) throws Exception {
        Drain drain = new Drain(name);
        drains.add(drain);
    }
    
    public Drain searchDrain(String name) throws Exception {
        return drains.stream().findFirst().filter(i -> i.getName().equals(name)).orElseThrow(() -> new Exception("No such drain"));
    }
    
    public void deleteDrain(String name) throws Exception {
        drains.remove(this.searchDrain(name));
    }


    public void savePlan(String path) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String text = gson.toJson(this);
        try (FileWriter writer = new FileWriter(path, false)) {
            writer.write(text);
        } catch (IOException ex) {
            System.out.println("Save error");
        }
    }
    
    public void loadPlan(String path) throws IOException, ClassNotFoundException {
        String text = "";
        Scanner in = new Scanner(new File(path));
        while(in.hasNextLine()){
            text += in.nextLine();
        }
        in.close();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Bathroom curr = gson.fromJson(text, Bathroom.class);
        this.tubes = curr.tubes;
        this.fittings = curr.fittings;
        this.waterConsumers = curr.waterConsumers;
        this.waterSources = curr.waterSources;
        this.drains = curr.drains;
        this.links = curr.links; }
}
