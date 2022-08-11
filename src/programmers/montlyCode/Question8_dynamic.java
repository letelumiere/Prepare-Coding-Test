package programmers.montlyCode;

import java.util.Arrays;

public class Question8_dynamic {
    static int answer;
    static int[][][] dp;

    //동적계획법으로 푼 문제 (3시간 걸림;;;; 그 중에서도 인덱스 때문에 엄청 헤멨음) 
    public int solution(int[] nums) {
        answer = 0;
        Arrays.sort(nums);
        dp = new int[nums.length][nums.length][nums.length];

        for(int i=0;i<nums.length-2;i++){
            recur(i, i+1, i+2, nums);
        }
        return answer;
    }
    

    public int recur(int n, int j, int k, int[] nums){
        if(j>=nums.length || k>=nums.length) return answer;
        else{
            if(j!=k && dp[n][j][k]==0){
                if(isPrime(nums[n]+nums[j]+nums[k])) { //System.out.println(nums[n]+" "+nums[j]+" "+nums[k]+" "+(nums[n]+nums[j]+nums[k]));
                    dp[n][j][k] = 1;
                    dp[n][k][j] = 1;
                    ++answer;
                }else {
                    dp[n][j][k] = -1;
                    dp[n][k][j] = -1;
                }
            }
            return recur(n, j+1, k, nums) + recur(n, j, k+1, nums);    
        }
    }

    public boolean isPrime2(int n){
        for (int i=2;i<=Math.sqrt(n);i++){
            if (n%i == 0) return false;
        }
        return true;
    }

    //if n이 false면 n=-1; true면 n=1;
    public boolean isPrime(int n){
        for(int i=2;i*i<=n;i++){
            if(n%i==0) return false;
            else{
                for(int j=i*i;j<=n;j+=i){
                    if(n%j==0) return false;
                }
            }
        }
        return true;
    }

}
