package programmers.montlyCode;

import java.util.Arrays;

public class Question8_greedy {
       //그리디로 푼 문제(10분 만에 풀림)
       public int solution(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            int n = i;

            for(int j=n+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(isPrime2(nums[n]+nums[j]+nums[k])) {
                        answer++;    
                    }
                }
            }
        }
        return answer>0 ? answer : 0;
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
