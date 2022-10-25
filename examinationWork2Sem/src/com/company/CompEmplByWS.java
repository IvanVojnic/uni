package com.company;

import java.util.Comparator;

public class CompEmplByWS implements Comparator<Empl> {
    @Override
    public int compare(Empl o1, Empl o2) {
        if(o1.getE_workload_sum() < o2.getE_workload_sum()){
            return -1;
        } else if(o1.getE_workload_sum() > o2.getE_workload_sum()){
            return 1;
        } else {
            return 0;
        }
    }
}
