package backjoon.dynamicP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Dynamic6 {
	public static int[] arr;		// 배열 
	public static Integer[] dp;		// 메모이제이션 할 dp
	public static int max;			// 최댓값 변수 


    //top-Down
    static int recur(int N) {   
        // 탐색하지 않은 인덱스라면 
        if(dp[N]==null) dp[N] = Math.max(recur(N - 1) + arr[N], arr[N]);  // (이전 배열의 누적합 + 현재 값)과 현재 값을 비교하여 최댓값을 N위치에 저장
        return dp[N];   // (이전 배열의 누적합 + 현재 값)과 현재 값을 비교하여 최댓값을 N위치에 저장    
    }

        //bottom-up
    static int[] bottomUp(int[] array, int N){
        for (int i=1;i<N;i++) dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        return arr;
    }
        
	public static void main(String[] args) throws Exception{        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N+1];
        dp = new Integer[N+1];

        for(int i=1;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }


        dp[1] = arr[1];
        int max = dp[1];
        for(int i=1;i<arr.length;i++){
            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}
