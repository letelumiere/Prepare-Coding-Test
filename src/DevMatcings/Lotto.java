package DevMatcings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Lotto {
    

    public int[] solution3(int[] lottos, int[] win_nums){
        HashMap<Integer, Boolean> hMap = new HashMap<>();
        int[] answer = new int[2];
        int zero = 0;

        for(int lotto : lottos){
            if(lotto==0) ++zero;
            else hMap.put(lotto, true);
        }

        int count = 0;
        for(int win_num : win_nums){
            if(hMap.containsKey(win_num)) ++count;
        }

        answer[0] = 7-(zero+count);
        answer[1] = 7-count;

        if(answer[0]==7) answer[0] -=1;
        if(answer[1]==7) answer[1] -=1;

        return answer;
    }


    public int[] solution(int[] lottos, int[] win_nums) {
        Queue<Integer> q = new LinkedList();
        int[] answer = {7, 7};

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int zero = 0;
        int count = 0;
        for(int i=0;i<lottos.length;i++){
            if(lottos[i]==0) ++zero;
            else q.add(lottos[i]);
        }

        int ptr = 0;
        while(!q.isEmpty()){
            int num = q.poll();
            for(int i=ptr;i<win_nums.length;i++){
                if(num==win_nums[i]){
                    ++count;
                    ++ptr;
                }
            }
        }
        
        answer[0] -= zero+count;
        answer[1] -= count;

        for(int i=0;i<answer.length;i++){
            if(answer[i]==7) answer[i] -=1;
        }

        return answer;
    }

    public int[] solution2(int[] lottos, int[] win_nums) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        int zeroCount = 0;

        for(int lotto : lottos) {
            if(lotto == 0) {
                zeroCount++;
                continue;
            }
            map.put(lotto, true);
        }


        int sameCount = 0;
        for(int winNum : win_nums) {
            if(map.containsKey(winNum)) sameCount++;
        }

        int maxRank = 7 - (sameCount + zeroCount);
        int minRank = 7 - sameCount;
        if(maxRank > 6) maxRank = 6;
        if(minRank > 6) minRank = 6;

        return new int[] {maxRank, minRank};
    }

    public static void main(String args[]){
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};	

        Lotto s = new Lotto();
        int[] result = s.solution3(lottos, win_nums);
        System.out.println(result[0]+" "+result[1]);
    }


    /*
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};	
            [3, 5]
        int[] lottos = {0, 0, 0, 0, 0, 0};
        int[] win_nums = {38, 19, 20, 40, 15, 25};	
            [1, 6]
        int[] lottos = {45, 4, 35, 20, 3, 9};
        int[] win_nums ={20, 9, 3, 45, 4, 35};
            [1, 1]
     */
}
