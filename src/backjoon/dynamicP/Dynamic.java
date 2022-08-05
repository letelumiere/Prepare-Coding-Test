package backjoon.dynamicP;

import java.util.Arrays;
public class Dynamic {
    
    public int solution(int N){
        int total = 0;
        
        total += N/5;
        N = N%5;

        total += N/3;
        N = N%3;

        if(N>0) return -1;
        else return total;

    }

    public static int fibonacci(int n){
        if(n>=2) return fibonacci(n-1)+fibonacci(n-2);
        else return 1;
    }
}
    
