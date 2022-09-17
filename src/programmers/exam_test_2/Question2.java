package programmers.exam_test_2;

import java.util.HashMap;

public class Question2 {    //제한시간 내 풀지 못함....
    int answer = 0;
    static int[] memo;

    public int solution(int[] topping) {
        memo = new int[topping.length];
        recursion(topping, topping.length/2);
        return answer;
    }





    public int recursion(int[] array, int n){   // int n은 mid
        HashMap<Integer, Integer> hMap1 = new HashMap<>();
        HashMap<Integer, Integer> hMap2 = new HashMap<>();

        if(n<0 || n==array.length) return n;
        if(memo[n]!=0) return memo[n];
        else{
            for(int i=0;i<n;i++){
                hMap1.put(array[i], hMap1.getOrDefault(array[i], 0)+1);
            }

            for(int j=n;j<array.length;j++){
                hMap2.put(array[j], hMap2.getOrDefault(array[j], 0)+1);
            }   

            if(hMap1.size()==hMap2.size()) {
                memo[n] = 1;
                ++answer;
            }else memo[n] = -1;
        }
        return recursion(array, n/2) + recursion(array, (n+array.length-1)/2);
    }
}
