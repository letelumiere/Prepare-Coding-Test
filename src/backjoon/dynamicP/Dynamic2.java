package backjoon.dynamicP;

import java.util.Scanner;

public class Dynamic2 {
    public static int cache[];

    public static int fibonacci(int n){
        cache[1] = cache[2] = 1;

        for(int i=3;i<=n;i++){
            cache[i] = cache[i-1] + cache[i-2];
        }
        
        return cache[n];
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        cache = new int[n+1];
        System.out.println(fibonacci(n)+" "+(n-2));
    }
}
