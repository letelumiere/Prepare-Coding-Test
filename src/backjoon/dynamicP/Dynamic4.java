package backjoon.dynamicP;

import java.util.Scanner;

public class Dynamic4 {
    public static int[] dp = new int[1000001];

    public static int tile(int N){
        if(dp[N]==-1) dp[N] = (tile(N-1) + tile(N-2)) % 15746;

        return dp[N];
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        dp[0] = 0; dp[1] = 1; dp[2] = 2;

        for(int i=3;i<dp.length;i++){
            dp[i] = -1;
        }

        int N = sc.nextInt();
        int result = tile(N);
        System.out.println(result);
    }

}


/*
    1   N=1
    00, 11  N=2
    0011, 0000, 1001, 1100, 1111  N=4


*/