package net.eta;

import java.util.Comparator;

public class SpeditionComparatorBuildYear implements Comparator<Vehicles> {
    @Override
    public int compare(Vehicles o1, Vehicles o2) {
        if(o1.getBuildYear().isBefore(o2.getBuildYear())){
            return 1;
        }
        return -1;
    }
}
