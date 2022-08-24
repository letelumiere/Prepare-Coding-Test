package programmers.basicKit.hash;

import java.util.HashMap;

public class Marathon {
    
    public String solution(String[] participant, String[] completion){
        HashMap<String, Integer> hMap = new HashMap<>();
        String answer = "";

        for(String player : participant) {
            hMap.put(player, hMap.getOrDefault(player, 0)+1);
        }
        for(String player : completion) {
            hMap.put(player, hMap.get(player)-1);
        }

        for(String key : hMap.keySet()){
            if(hMap.get(key)>0){
                answer = key;
                break;
            }
        }
        return answer;
    }
}
