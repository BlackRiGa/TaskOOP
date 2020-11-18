package com.mycompany.kurs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static com.mycompany.kurs.Bathroom.getInstance;
import static com.mycompany.kurs.TextInterface.userInteraction;

public class Main {

    public static void main(String[] args) {
        Bathroom test = getInstance();
        userInteraction(test);
    }
}
