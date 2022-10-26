package programmers.basicKit.sort;

import java.util.*;

public class MaxNumber {
    public String solution(int[] numbers){
        String[] nums = new String[numbers.length];
        
        for(int i=0;i<nums.length;i++){
            nums[i] = numbers[i]+"";
        }
        
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
    

        String answer = "";
        for(int i=0;i<numbers.length;i++){
            answer += nums[i];
        }

        return answer.charAt(0) == '0' ? "0":answer;
    }
}
