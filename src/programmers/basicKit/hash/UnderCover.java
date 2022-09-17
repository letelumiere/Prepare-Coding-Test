package programmers.basicKit.hash;
import java.util.*;

public class UnderCover {
    public int solution(String[][] clothes) {
        Map<String, Integer> hMap = new HashMap<>();
        int answer = 1;
        
        for(int i=0;i<clothes.length;i++) {
            hMap.put(clothes[i][1], hMap.getOrDefault(clothes[i][1], 0)+1);
        }

        
        for(String outfit : hMap.keySet()) {
            answer = answer * (hMap.get(outfit)+1);
        }        
        return --answer;
    }
}

