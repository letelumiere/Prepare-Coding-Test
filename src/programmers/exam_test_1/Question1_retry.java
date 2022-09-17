package programmers.exam_test_1;

import java.util.*;

public class Question1_retry {
    public static String solution(String X, String Y){
        PriorityQueue<Character> queue = new PriorityQueue<>(Comparator.reverseOrder());
        HashMap<Character, Integer> hMap = new HashMap();
        StringBuilder answer = new StringBuilder();

        for(int i=0;i<X.length();++i){
            char n = X.charAt(i);
            hMap.put(n, hMap.getOrDefault(n, 0)+1);
        }

        for(int i=0;i<Y.length();++i){
            char n = Y.charAt(i);
            if(!hMap.isEmpty() && hMap.containsKey(n) && hMap.get(n)>0) {
                queue.add(n);
                hMap.put(n, hMap.get(n)-1);
            }
        }

        if(!queue.isEmpty()){
            while(!queue.isEmpty()) answer.append(queue.poll());
            return answer.charAt(0) == '0' ? "0" : answer.toString();
        }else return "-1";
    }

    
    public static void main(String args[]){
        System.out.println(solution("3403", "3230"));
    }
}
