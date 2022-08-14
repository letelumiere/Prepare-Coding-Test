package kakao.blind_recruitment2022;

import java.util.*;

public class Level1 {
    public int[] solution(String[] id_list, String[] report, int k) {        
        HashSet<String> set = new HashSet<>();
        Map<String, Integer> idxMap = new HashMap<>();
        Map<String, ArrayList<String>> penaltyMap = new HashMap<>(); 
        ArrayList<String> alist;
        int[] answer = new int[id_list.length]; 

        for(int i=0;i<id_list.length;++i) idxMap.put(id_list[i], i);
        for(String s : report) set.add(s);

        Iterator<String> iter = set.iterator();
        while(iter.hasNext()){
            String[] temp = iter.next().split(" ");
            String key_0 = temp[0]; String key_1 = temp[1];    
            
            if(penaltyMap.get(key_1)!=null) alist = penaltyMap.get(key_1);
            else alist = new ArrayList<>();

            alist.add(key_0);
            penaltyMap.put(key_1, alist);
        }

        for(String key : penaltyMap.keySet()){
            alist = penaltyMap.get(key);

            if(alist.size()>=k) {
                for(String s : alist) answer[idxMap.get(s)]++;
            }
            
        }
        return answer;        
    }
}
