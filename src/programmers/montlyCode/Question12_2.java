package programmers.montlyCode;

import java.util.*; 


public class Question12_2 {    

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length]; 
        Map<String, Integer> idxMap = new HashMap<>();
        Map<String, ArrayList<String>> reportMap = new HashMap<>();
        Map<String, ArrayList<String>> penaltyMap = new HashMap<>();  //해당 
        HashSet<String> set = new HashSet<>();        
        ArrayList<String> alist;

        for(int i=0;i<id_list.length;i++) {
            idxMap.put(id_list[i], i);
        }

        for(int i=0;i<report.length;i++){
            set.add(report[i]);
        }

        Iterator<String> iter = set.iterator();
        while(iter.hasNext()){
            String str = iter.next();
            String[] temp = str.split(" ");
            String key_0 = temp[0];
            String key_1 = temp[1];
            
            if(reportMap.get(key_0)!=null) alist = new ArrayList(reportMap.get(key_0));
            else alist = new ArrayList<>();
            alist.add(key_1);
            reportMap.put(key_0, alist);
            

            if(penaltyMap.get(key_1)!=null) alist = new ArrayList(penaltyMap.get(key_1));
            else alist = new ArrayList<>();
            alist.add(key_0);
            penaltyMap.put(key_1, alist);
        }


        for(String key : penaltyMap.keySet()){
            alist = new ArrayList(penaltyMap.get(key));
            
            if(alist.size()>=k){
                for(String s : alist){
                    answer[idxMap.get(s)]++;
                }
            }

        }
/*
        for(String key : reportMap.keySet()){
            System.out.println(key+" "+reportMap.get(key));   
        }

        for(String key : penaltyMap.keySet()){
            System.out.println(key+" "+penaltyMap.get(key));   
        }

        


        
        
        for(String s : hMap.keySet()){
            String[] temp = hMap.get(s).split(" ");
            
            if(temp.length>=k){
                for(int j=0;j<temp.length;j++){
                    int idx = hMap2.get(temp[j]);
                    answer[idx]++;
                }
            }
        }

        */
        return answer;
        
    }

    public static void main(String args[]){
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo", "apeach muzi"};


        int[] result = solution(id_list, report, 2);

        System.out.print("result : ");
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }
}
