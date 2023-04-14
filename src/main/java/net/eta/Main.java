package net.eta;

import java.time.Year;

public class Main {
    public static void main(String[] args) {

        try {
            Spedition s1 = new Spedition(100000l);
            Spedition s2 = new Spedition(200000l);
            Vehicles t1 = new Vehicles(10000f,100000,null, Year.now());
            Vehicles t2 = new Vehicles(5000f,160000,null, Year.of(2001));
            s1.addVehicle(t1);
            System.out.println(s1.toString());
        } catch (SpeditionException e) {
            throw new RuntimeException(e);
        }
    }
}