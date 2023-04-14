package net.eta;

import java.util.Comparator;

public class SpeditionComparatorBuildYear implements Comparator<Vehicles> {
    @Override
    public int compare(Vehicles o1, Vehicles o2) {
        return o1.getBuildYear().compareTo(o2.getBuildYear());
    }
}
