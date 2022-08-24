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
    

    //2번째 풀이
    public static int[] solution_2(String[] id_list, String[] report, int k) {        
        int[] answer = new int[id_list.length];
        HashMap<String, Set<String>> hMap = new HashMap<>();
        HashMap<String, Integer> idxMap = new HashMap<>();
        Set<String> set;

        for(int i=0;i<id_list.length;i++){
            idxMap.put(id_list[i], i);
        }
        
        for(int i=0;i<report.length;i++){
            String[] temp = report[i].split(" ");
            
            hMap.put(temp[1], hMap.getOrDefault(temp[1], new HashSet<>()));

            if(hMap.get(temp[1])==null) set = new HashSet<>();
            else set = hMap.get(temp[1]);

            set.add(temp[0]);
            hMap.put(temp[1], set);
        }

        for(String key : hMap.keySet()){
            if(hMap.get(key).size()>=k){
                set = hMap.get(key);

                Iterator<String> iter = set.iterator();
                while(iter.hasNext()){
                    String s = iter.next();
                    int idx = idxMap.get(s);
                    answer[idx]++;
                }
            }
        }
        return answer;        
    }
    

    public static void main(String args[]){
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};


        int[] result = solution_2(id_list, report, 2);

        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
