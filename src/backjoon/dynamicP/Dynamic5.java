package backjoon.dynamicP;

import java.util.Scanner;

public class Dynamic5 {
    static int[] dp;

    public static int fibonacci(int n){
        if(n<=3 || dp[n]!=0) return dp[n];
        return dp[n] = fibonacci(n-2)+fibonacci(n-3);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
        int[] array = new int[T];

        dp = new int[100+1];
        dp[1] = 1; dp[2] = 1; dp[3] = 1;
        
        for(int i=0;i<T;i++){
            array[i] = fibonacci(sc.nextInt());           
        }

        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
        



    }
}