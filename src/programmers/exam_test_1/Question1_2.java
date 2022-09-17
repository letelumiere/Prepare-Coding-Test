package programmers.exam_test_1;

import java.util.Arrays;
import java.util.HashMap;

public class Question1_2 {
    public static String solution(String X, String Y){
        HashMap<Character, Integer> hMap = new HashMap<>();
        String answer ="";

        for(int i=0;i<X.length();i++){
            char n = X.charAt(i);
            hMap.put(n, hMap.getOrDefault(n, 0)+1);
        }

        for(int i=0;i<Y.length();i++){
            char n = Y.charAt(i);
            if(!hMap.isEmpty() && hMap.containsKey(n) && hMap.get(n)>0){
                answer += n;
                hMap.put(n, hMap.get(n)-1);
            }
        }

        char[] array = answer.toCharArray();
        Arrays.sort(array);
        answer = "";

        for(int i=array.length-1;i>=0;i--){
            answer += array[i];
        }
        return answer.charAt(0)=='0' ? "0" : answer ;
    }
}
