package programmers.montlyCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Question12_failed {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[] cntArr = new int[id_list.length];
        HashMap<String, String> hMap = new HashMap<>();
        ArrayList<String> alist = new ArrayList<>();
    
        for(int i=0;i<id_list.length;i++){
            String s1 = id_list[i];

            for(String str : report){
                String[] temp = str.split(" ");
                
                if(hMap.get(temp[0])==null) {
                    hMap.put(temp[0], temp[1]);
                }else {
                    if(!hMap.get(temp[0]).contains(temp[1])){
                        hMap.put(temp[0], temp[1]+" "+hMap.get(temp[0]));
                    }
                } 
            }
        }


        
        for(String key : hMap.keySet()){
            System.out.println(key+": "+hMap.get(key));
        }

        for(int i=0;i<id_list.length;i++){
            String id = id_list[i];

            for(String key : hMap.keySet()){
                if(hMap.get(key).contains(id)) cntArr[i]++;
            }
            
        }

        for(int i=0;i<cntArr.length;i++){
            String ban = id_list[i];


        }

        return answer;
    }

    public static int[] solution2(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> hMap1 = new HashMap<>();
        HashMap<String, String> hMap2 = new HashMap<>();
        
        int[] answer = new int[id_list.length];

        Arrays.sort(report);

        for(int i=0;i<id_list.length;i++){
            hMap2.put(id_list[i], "");
        }


        String str = "";
        String s1 =""; String s2 ="";
        String[] temp;
        for(int i=0;i<report.length;i++){
            temp = report[i].split(" ");

            if(!s1.equals(temp[0])) str += (temp[1]+" ");
            
        }

        temp = str.split(" ");
        for(int i=0;i<temp.length;i++){
            hMap1.put(temp[i], hMap1.getOrDefault(temp[i], 0)+1);
        }

        for(String key : hMap1.keySet()){
            if(hMap1.get(key)>=k){
                
            }
        }





        return answer;
    }


    public static void main(String args[]){
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};


        int[] result = solution2(id_list, report, 2);

        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}


