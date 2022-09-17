package programmers.exam_test_3;

import java.util.LinkedList;
import java.util.Stack;

public class Question2 {    //20분 소요
    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack();
        int[] temp = new int[4];
        int answer = 0;

        for(int i=0;i<ingredient.length;i++){
            stack.add(ingredient[i]);

            if(stack.size()>=4 && stack.peek()==1){
                for(int j=temp.length-1;j>=0;j--){
                    temp[j] = stack.pop();
                }

                String st ="";
                for(int k : temp) st += ""+k;
                
                if(st.equals("1231")) answer++;
                else for(int j: temp) stack.add(j);
            }
        }
        return answer;
    }

    public static void main(String args[]){
        Question2 s = new Question2();
    }
}
