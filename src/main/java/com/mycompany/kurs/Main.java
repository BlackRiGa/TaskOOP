package com.mycompany.kurs;

import java.io.IOException;

import static com.mycompany.kurs.Bathroom.getInstance;
import static com.mycompany.kurs.TextInterface.userInteraction;

public class Main {

    public static void main(String[] args) throws IOException {
        Bathroom test = getInstance();
        userInteraction(test);
    }
}
