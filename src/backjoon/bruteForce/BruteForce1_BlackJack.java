package backjoon.bruteForce;

import java.util.*;

public class BruteForce1_BlackJack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] array = new int[N];

        for(int i=0;i<N;i++){
            array[i] = sc.nextInt();
        }

        int result = 0;
        for(int i=0;i<array.length-2;i++){
            for(int j=i+1;j<array.length-1;j++){
                for(int k=j+1;k<array.length;k++){
                    if(array[i]+array[j]+array[k]<=M) result = Math.max(result, array[i]+array[j]+array[k]);
                    
                }
            }
        }

        System.out.println(result);
    }
}
