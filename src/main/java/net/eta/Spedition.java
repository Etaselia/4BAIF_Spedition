package net.eta;

import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;

public class Spedition {
    private long uid;
    private ArrayList<Vehicles> vehicles = new ArrayList<Vehicles>(10);

    public Spedition(long uid) throws SpeditionException {
        if(uid >= 100000){
            this.uid = uid;
            return;
        }
        throw new SpeditionException("UID not accepted");
    }

    public long getUid() {
        return uid;
    }

    public ArrayList<Vehicles> getVehicles() {
        return vehicles;
    }
    public void setVehicles(ArrayList<Vehicles> vehicles) {
        this.vehicles = vehicles;
    }

    public void addVehicle(Vehicles vehicle) throws SpeditionException {
        if(vehicle.getOwner() == null){
            if(!vehicles.contains(vehicle)){
                vehicle.setOwner(this);
                vehicles.add(vehicle);
                return;
            }
        }
        throw new SpeditionException("Error adding vehicle");
    }

    public Vehicles removeVehicle(Vehicles vehicle){
        if (vehicles.contains(vehicle)){
            vehicles.remove(vehicle);
            vehicle.setOwner(null);
            return vehicle;
        }
        return null;
    }

    public int removeVehicle(Year buildYear){
        Iterator iter = vehicles.iterator();
        int counter = 0;
        while(iter.hasNext()){
            Vehicles o = (Vehicles) iter.next();
            if (o.getBuildYear() == buildYear) {
                o.setOwner(null);
                iter.remove();
                counter++;
            }
        }
        return counter;
    }

    public float totalLoad(){
        float totalLoad = 0;
        for (Vehicles o: vehicles) {
            totalLoad += o.getLoad();
        }
        return totalLoad;
    }

    public float avgLoad() throws SpeditionException {
        float avgLoad = 0;
        for (Vehicles o: vehicles) {
            avgLoad += o.getLoad();
        }
        if (avgLoad != 0 && vehicles.size() != 0){
            return avgLoad/vehicles.size();
        }
        throw new SpeditionException("avg Load Error");
    }

    public void sortBuildYear(){
        vehicles.sort(new SpeditionComparatorBuildYear());
    }

    public void sortLoad(){
        vehicles.sort(new SpeditionComparatorLoad());
    }

    @Override
    public String toString() {
        return "Spedition{" +
                "uid=" + uid +
                ", vehicles=" + vehicles +
                '}';
    }
}
