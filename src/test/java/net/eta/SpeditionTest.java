package net.eta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Parameter;
import java.time.Year;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SpeditionTest {

    @BeforeEach
    void setUp() {
        try {
            Spedition s1 = new Spedition(100000);
            Spedition s2 = new Spedition(200000);
            Vehicles t1 = new Vehicles(10000f,100000,null, Year.now());
            Vehicles t2 = new Vehicles(5000f,160000,null, Year.of(2001));
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
            System.out.println("Error in Constructor!!!");
        }
    }

    @Test
    void SpeditionConstructor(){
        try {
            Spedition s1 = new Spedition(100000l);
            assert (s1 != null);
        } catch (SpeditionException e) {
            fail();
        }
    }

    @Test
    void TransporterConstructor(){
        try {
            Vehicles t1 = new Vehicles(10000f,100000,null, Year.now());
            assert (t1 != null);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void addVehicle(Spedition s1, Spedition s2, Vehicles t1, Vehicles t2) {
        try {
            s1.addVehicle(t1);
            ArrayList<Vehicles> v1 = s1.getVehicles();
            s1.addVehicle(t1);
            if (v1 != s1.getVehicles()){
                fail();
            }
            assert (s1.getVehicles().contains(t1));
        } catch (SpeditionException e) {
            fail();
        }
    }

    @Test
    void removeVehicle(Spedition s1, Spedition s2, Vehicles t1, Vehicles t2) {
    }

    @Test
    void testRemoveVehicle(Spedition s1, Spedition s2, Vehicles t1, Vehicles t2) {
    }

    @Test
    void totalLoad(Spedition s1, Spedition s2, Vehicles t1, Vehicles t2) {
    }

    @Test
    void avgLoad(Spedition s1, Spedition s2, Vehicles t1, Vehicles t2) {
    }

    @Test
    void sortBuildYear(Spedition s1, Spedition s2, Vehicles t1, Vehicles t2) {
    }

    @Test
    void sortLoad(Spedition s1, Spedition s2, Vehicles t1, Vehicles t2) {
    }
}