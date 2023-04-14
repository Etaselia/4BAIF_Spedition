package net.eta;

import java.time.Year;

public class Vehicles {
    private float ownWeight;
    private double maxWeight;
    private int load;
    private Spedition owner;
    private Year buildYear;

    public Vehicles(float ownWeight, double maxWeight, Spedition owner, Year buildYear) {
        this.ownWeight = ownWeight;
        this.maxWeight = maxWeight;
        this.owner = owner;
        this.buildYear = buildYear;
    }

    public float getOwnWeight() {
        return ownWeight;
    }

    public void setOwnWeight(float ownWeight) {
        this.ownWeight = ownWeight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getLoad() {
        return load;
    }

    public Spedition getOwner() {
        return owner;
    }

    public void setOwner(Spedition owner) {
        this.owner = owner;
    }

    public Year getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(Year buildYear) {
        this.buildYear = buildYear;
    }
    @Override
    public String toString() {
        return "Transporter{" +
                "ownWeight=" + ownWeight +
                ", maxWeight=" + maxWeight +
                ", load=" + load +
                ", owner=" + owner.getUid() +
                ", buildYear=" + buildYear +
                '}';
    }

    public void load(int weight) throws SpeditionException {
        if (weight + load <= maxWeight*1000){
            load += weight;
        }else {
            throw new SpeditionException("maxWeight over load Limit");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicles that = (Vehicles) o;

        if (Float.compare(that.getOwnWeight(), getOwnWeight()) != 0) return false;
        if (Double.compare(that.getMaxWeight(), getMaxWeight()) != 0) return false;
        return getBuildYear().equals(that.getBuildYear());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (getOwnWeight() != +0.0f ? Float.floatToIntBits(getOwnWeight()) : 0);
        temp = Double.doubleToLongBits(getMaxWeight());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getBuildYear().hashCode();
        return result;
    }
}
