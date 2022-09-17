package programmers.exam_test_1;

import java.util.Arrays;
import java.util.HashMap;

public class Question2_2 {
    public int solution(String[] want, int[] number, String[] discount){
        HashMap<String, Integer> hMap = new HashMap<>();
        int answer = 0;

        for(int i=0;i<want.length;i++){
            hMap.put(want[i], i);
        }   

        for(int i=0;i<discount.length;i++){
            int[] temp = number.clone();

            for(int j=i; j<j+10 || j<discount.length ;j++){
                if(hMap.containsKey(discount[j])) temp[j]--;
            }

            Arrays.sort(temp);
            if(temp[temp.length-1]==0) answer++;
        }
        return answer;
    }

}
