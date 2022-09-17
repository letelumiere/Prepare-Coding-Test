package programmers.exam_test_1;

import java.util.HashMap;

public class Question2_retry {
    public int solution(String[] want, int[] number, String[] discount){
        HashMap<String, Integer> hMap;
        int answer = 0;

        for(int i=0;i<discount.length-10;i++){
            hMap = new HashMap<>();

            for(int j=0;j<want.length;j++){
                hMap.put(want[j], hMap.getOrDefault(want[j], number[j]));
            }

            for(int k=0;k<10;k++){
                if(hMap.containsKey(discount[k]) && hMap.get(discount[k])>0) {
                    hMap.put(discount[k], hMap.get(discount[k])-1);
                }
            }
            
            if(hMap.size()==0) answer++;
        }   


        return answer;
    }


    public int solution2(String[] want, int[] number, String[] discount){
        HashMap<String, Integer> hMap = new HashMap<>();
        int answer = 0;


        for(int i=0;i<want.length;i++){
            hMap.put(want[i], i);
        }

        for(int i=0;i<discount.length;i++){
            int[] goods = number.clone();

            int max = 0;
            for(int j=i;j<10 || j<discount.length;j++){
                String key = discount[j];
                int item = hMap.get(key);

                if(goods[item]>0) goods[item]--;
                max = Math.max(goods[item], max);
            }
            if(max==0) answer++;
        }  


        return answer;
    }

    public int solution3(String[] want, int[] number, String[] discount){
        HashMap<String, Integer> hMap = new HashMap<>();
        int answer = 0;


        for(int i=0;i<want.length;i++){
            hMap.put(want[i], i);
        }

        for(int i=0;i<discount.length;i++){
            int[] goods = number.clone();

            int max = 0;
            for(int j=i;j<j+10 || j<discount.length;j++){
                String key = discount[j];
                int item = hMap.get(key);
                
                if(hMap.containsKey(key)) goods[item]--;
                max = Math.max(goods[item], max);
            }
            if(max==0) answer++;
        }  


        return answer;
    }
}
