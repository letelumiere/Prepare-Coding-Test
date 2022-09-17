package programmers.exam_test_1;

import java.util.Arrays;
import java.util.HashMap;

public class Question2 {
    public int solution2(String[] want, int[] number, String[] discount){
        HashMap<String, Integer> hMap = new HashMap<>();
        int answer = 0;

        for(int i=0;i<want.length;i++){
            hMap.put(want[i], i);
        }   

        for(int i=0;i<discount.length;i++){
            int[] temp = number.clone();

            for(int j=i; j<j+10 || j<discount.length ;j++){
                if(hMap.containsKey(discount[j]) && hMap.get(discount[j])>0) temp[j]--;
            }

            Arrays.sort(temp);
            if(temp[temp.length-1]==0) answer++;
        }
        return answer;
    }


    public int solution(String[] want, int[] number, String[] discount) {
        boolean[] memo = new boolean[discount.length];
        HashMap<String, Integer> hMap;
        int answer = 0;

        for(int i=0;i<memo.length;i++){
            hMap = new HashMap<>();
            memo[i] = true;

            for(int k=0;k<want.length;k++){
                hMap.put(want[k], hMap.getOrDefault(want[k], number[k]));
            }
            
            for(int j=i;j<i+10;j++){
                String item = discount[j];

                if(j<discount.length && ((hMap.get(item)!=null && hMap.get(item)>0))){
                    hMap.put(item, hMap.get(item)-1);
                }else {
                    break;
                }
            }   
            for(String key : hMap.keySet()){
                if(hMap.get(key)>0) {
                    memo[i] = false;
                    break;
                }
            }
            if(memo[i]==true) answer+=1;
        }
        return answer;
    }
}
