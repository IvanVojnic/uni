package com.company;

import java.util.Comparator;

public class CompEmplById implements Comparator<Empl> {

    @Override
    public int compare(Empl o1, Empl o2) {
        if(o1.getE_id() < o2.getE_id()){
            return -1;
        } else if(o1.getE_id() > o2.getE_id()){
            return 1;
        } else {
            return 0;
        }
    }
}
