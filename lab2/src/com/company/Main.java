package com.company;
import java.util.Scanner;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input num of columns: ");
        int col = in.nextInt();
        System.out.print("Input num of rows: ");
        int row = in.nextInt();
        System.out.print("Input below range: ");
        int n_belowRang  = in.nextInt();
        int[][] matrTOchange = new int[row][col];
        for (int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int val = in.nextInt();
                matrTOchange[i][j] = val;
            }
        }
        in.close();
        for (int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(matrTOchange[i][j] + " ");
            }
            System.out.println();
        }
        Map<Integer, Integer> mutipIndex = new HashMap<Integer, Integer>();
        int [][] multipArr = new int [col][2];
        for(int j = 0; j < col; j++)
        {
            boolean okCol = true;
            int tmpMinMultip = 1;
            for(int i = 0; i < row; i++){
                if(Math.abs(matrTOchange[i][j]) <= n_belowRang){
                    tmpMinMultip = tmpMinMultip * matrTOchange[i][j];
                }
                else {
                    okCol = false;
                    break;
                }
            }
            if(okCol){
                mutipIndex.put(tmpMinMultip, j+1);
            }
        }
        if(mutipIndex.isEmpty()){
            mutipIndex.put(0,0);
        }
        int firstKey = mutipIndex.entrySet().stream().min((a,b) -> a.getValue().compareTo(b.getValue())).get().getKey();
        if(mutipIndex.get(firstKey) == 0)
        {
            System.out.println("NO COLUMNS");
        } else {
            System.out.println("Okey column is under number:");
            System.out.println(mutipIndex.get(firstKey));
        }
    }
}
