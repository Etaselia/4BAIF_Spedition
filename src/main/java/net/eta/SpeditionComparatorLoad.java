package net.eta;

import java.util.Comparator;

public class SpeditionComparatorLoad implements Comparator<Vehicles> {
    @Override
    public int compare(Vehicles o1, Vehicles o2) {
        return Integer.compare(o1.getLoad(),o2.getLoad());
    }
}
