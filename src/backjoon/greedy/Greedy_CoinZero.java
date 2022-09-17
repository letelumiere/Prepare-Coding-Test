package backjoon.greedy;

import java.util.*;

public class Greedy_CoinZero {
    public static int[] units;
    
    public static int solution(int total){
        int answer = 0;

        for(int i=units.length-1;i>=0;--i){
            if(units[i]<=total){
                answer += total/units[i];
                total %= units[i];
            }
        }

        return answer;
    }


    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        units = new int[N];
        
        for(int i=0;i<units.length;i++){
            units[i] = sc.nextInt();
        }

        int result = solution(K);
        System.out.println(result);
        sc.close();
    }
}
