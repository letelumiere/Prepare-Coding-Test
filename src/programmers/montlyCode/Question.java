package programmers.montlyCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class Question {
    static int[][] dp;
    static int n;
    
    public static int[] solution(int[] numbers) {
        n = numbers.length;
        dp = new int[n][n];
        TreeSet<Integer> treeSet = new TreeSet();

        dynamic(n-1, n-1, numbers);

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                if(dp[i][j]!=0) treeSet.add(dp[i][j]);
            }
        }

        int[] answer = new int[treeSet.size()];        
        for(int i=0;i<answer.length;i++){
            answer[i] = treeSet.pollFirst();
        }

        return answer;
    }


    public static int dynamic(int n, int k, int[] numbers){
        if(n<0 || k<0) return 1;
        else{
            if(dp[n][k]==0 && n!=k) dp[n][k] = numbers[n]+numbers[k];
            else if(dp[n][k]>0 && n!=k) return dp[n][k];
        }
        return dynamic(n-1, k, numbers) + dynamic(n, k-1, numbers);
    }

    public static int[] sol(int[] numbers){
        int[] answer = {};
        TreeSet<Integer> treeSet = new TreeSet();

        for(int i=0;i<numbers.length;i++){
            for(int j=0;j<numbers.length;j++){
                if(i!=j) treeSet.add(numbers[i]+numbers[j]);
            }
        }
        answer = new int[treeSet.size()];        

        for(int i=0;i<answer.length;i++){
            answer[i] = treeSet.pollFirst();
        }


        return answer;
    }



    public static void main(String args[]){
        int[] numbers = {2,1,3,4,1};
    }
}