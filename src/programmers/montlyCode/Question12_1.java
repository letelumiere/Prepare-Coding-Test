package programmers.montlyCode;

import  java.util.*;

public class Question12_1 { 

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length]; 
        Map<String, String> hMap = new HashMap<>();
        Map<String, Integer> hMap2 = new HashMap<>();
        Set<String> set = new HashSet<>();

        for(int i=0;i<id_list.length;i++){
            hMap2.put(id_list[i], i);
        }

        for(String str : report){
            set.add(str);
        }
        
        Iterator<String> iter = set.iterator();
        while(iter.hasNext()){
            String str = iter.next();

            String[] temp = str.split(" ");
            String reporter = temp[0];
            
            for(int i=1;i<temp.length;i++){
                String id = temp[i];

                if(hMap.get(id)==null) {
                    hMap.put(id, reporter);
                }else if(!hMap.get(id).contains(reporter)){
                    hMap.put(id, hMap.get(id)+" "+reporter);
                }
            
            }
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
        return answer;
        
    }

    public static int[] solution2(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length]; 
        HashMap<String, Integer> hMap = new HashMap<>();
        String[] cntArr = new String[id_list.length];

        Arrays.sort(report);
        for(int i=0;i<id_list.length;++i){
            hMap.put(id_list[i], i);
        }

        //각 idx를 신고한 이들의 목록
        for(int i=0;i<report.length;++i){
            String[] temp = report[i].split(" ");
            String reporter = temp[0];
            
            for(int j=1;j<temp.length;++j){
                int idx = hMap.get(temp[j]);

                if(cntArr[idx]==null) cntArr[idx] = reporter;
                if(!cntArr[idx].contains(reporter)) cntArr[idx] += " "+reporter;
            }

        /*
            //각 idx가 신고한 id 목록
            int idx = hMap.get(temp[0]);
            for(int j=1;j<temp.length;j++){
                int idx2 = hMap.get(temp[j]);
                if(cntArr[idx2]==null) cntArr[j] = temp[idx];
                if(!cntArr[idx].contains(temp[j])) cntArr[idx] += " "+temp[j]; 
            }
        */
        }

        for(int i=0;i<cntArr.length;++i){
            if(cntArr[i]!=null){
                String[] temp = cntArr[i].split(" ");
                System.out.println(temp[0]);
                if(temp.length>=k){
                    for(int j=0;j<temp.length;++j){
                        int idx = hMap.get(temp[j]);
                        ++answer[idx];
                    }

                }
            }
        }


        return answer;
    }
    public static void main(String args[]){
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};


        int[] result = solution(id_list, report, 2);

        System.out.print("result : ");
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }
}
