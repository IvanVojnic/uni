//package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //System.out.print("Input count of elems: ");
        int val1 = in.nextInt();
        int val2 = in.nextInt();
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        //System.out.print("Input elems arr1: ");
        for(int i = 0; i < val1; i++){
            int tmp = in.nextInt();
            arr1.add(tmp);
        }
        //System.out.print("Input elems arr2: ");
        for(int i = 0; i < val2; i++){
            int tmp = in.nextInt();
            arr2.add(tmp);
        }
        Collections.sort(arr1);
        for(int i = 0; i < val2; i++){
            int index = Collections.binarySearch(arr1, arr2.get(i));
            index++;
            if(index < 0){
                index = Math.abs(index);
                if(index == arr1.size()){
                    System.out.println(arr1.get(index -1));
                } else {
                    int el1Arr1 = arr1.get(index-1);
                    int el2Arr1 = arr1.get(index);
                    if(arr2.get(i) - el1Arr1 < el2Arr1 - arr2.get(i)){
                        System.out.println(arr1.get(index -1));
                    } else if(arr2.get(i) - el1Arr1 == el2Arr1 - arr2.get(i)){
                        System.out.println(arr1.get(index - 1));
                    }
                    else{
                        System.out.println(arr1.get(index));
                    }
                }
            }
            else {
                if(index == 0){
                    System.out.println(arr1.get(0));
                } else {
                    System.out.println(arr1.get(index - 1));
                }
            }
        }
    }
}
