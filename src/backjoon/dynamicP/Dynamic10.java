package backjoon.dynamicP;

import java.util.Scanner;

public class Dynamic10 {
	static Long[][] dp;
	static int N;
	final static long mod = 1000000000;

	//bottom-up
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		long[][] dp = new long[N + 1][10];
		
		// 첫 번째 자릿수는 오른쪽 맨 끝의 자릿수이므로 경우의 수가 1개밖에 없음 
		for(int i = 1; i < 10; i++) {
			dp[1][i] = 1; 
		}
		
		// 두 번째 자릿수부터 N까지 탐색 
		for(int i = 2; i <= N; i++) {
			
			// i번째 자릿수의 자릿값들을 탐색 (0~9) 
			for(int j = 0; j < 10; j++) {
				
				// j=0, 즉 자릿값이 0이라면 이전 자릿수의 첫번째 자릿수만 가능 
				if(j == 0) {
					dp[i][0] = dp[i - 1][1] % mod;
				}
				// j=9라면 이전 자릿수는 8만 가능
				else if (j == 9) {
					dp[i][9] = dp[i - 1][8] % mod;
				}
				// 그 외의 경우 이전 자릿수의 자릿값 +1, -1 의 합이 됨 
				else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
				}
			}
		}
		
		long result = 0;
		
		// 각 자릿값마다의 경우의 수를 모두 더해준다. 
		for(int i = 0; i < 10; i++) {
			result += dp[N][i];
		}
		System.out.println(result % mod);


	}

	//Top-down
	static long recur(int digit, int val) {		
 
		// 첫째 자리수에 도착한다면 더이상 탐색할 필요 없음
		if(digit == 1) {
			return dp[digit][val];
		}
			
		// 해당 자리수의 val값에 대해 탐색하지 않았을 경우 
		if(dp[digit][val] == null) {
			// val이 0일경우 다음은 1밖에 못옴
			if(val == 0) {
				dp[digit][val] = recur(digit - 1 ,1);
			}
			// val이 1일경우 다음은 8밖에 못옴
			else if(val== 9) {
				dp[digit][val] = recur(digit - 1, 8);
			}
			// 그 외의 경우는 val-1과 val+1 값의 경우의 수를 합한 경우의 수가 됨
			else {
				dp[digit][val] = recur(digit - 1, val - 1) + recur(digit - 1, val + 1);
			}
		}
		return dp[digit][val] % mod;
	}

}