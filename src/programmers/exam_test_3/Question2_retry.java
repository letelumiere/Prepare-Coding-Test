package programmers.exam_test_3;

import java.util.*;

public class Question2_retry {
    
    public int solution(int[] ingredient){
        Stack<Integer> stack = new Stack();
        StringBuffer sb;
        int[] temp;
        int answer = 0;

        for(int i=0;i<ingredient.length;i++){
            stack.add(ingredient[i]);

            if(stack.size()>=4 && stack.peek()==1){
                sb = new StringBuffer();
                temp = new int[4];

                for(int j=temp.length-1;j>=0;j--){
                    temp[j] = stack.pop();
                    sb.append(temp[j]);
                }

                if(sb.toString().equals("1231")) answer++;
                else for(int j : temp) stack.add(j);
            }
        }        
        return answer;
    }

}
