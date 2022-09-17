package programmers.exam_test_2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Question2_2 {  
    public static int solution(int[] topping) {
        HashMap<Integer, Integer> hMap1 = new HashMap<>();
        HashMap<Integer, Integer> hMap2 = new HashMap<>();
    
        int answer = 0;

        for(int i=0;i<topping.length;i++){
            hMap2.put(topping[i], hMap2.getOrDefault(topping[i], 0)+1);
        }

        for(int i=0;i<topping.length;i++){
            if(!hMap2.isEmpty() && (hMap2.get(topping[i])!=null)){
                hMap1.put(topping[i], hMap1.getOrDefault(topping[i], 0)+1);
                hMap2.put(topping[i], hMap2.get(topping[i])-1);
            }

            if(hMap2.get(topping[i])==0) hMap2.remove(topping[i]);   
            if(hMap1.size()==hMap2.size()) answer++;
        }
        return answer;
    }

    public static void main(String arg[]){
//       Lv2_2 s = new Lv2_2();
       int[] topping = {1, 2, 3, 1, 4}; //result 0
//       int[] topping = {1, 2, 1, 3, 1, 4, 1, 2}; //result 2
       System.out.println(solution(topping));
    }
}
