package programmers.exam_test_1;

import java.util.*;

public class Question3_retry {
    public static int solution(int[] order){
        Queue<Integer> queue = new LinkedList();
        Stack<Integer> stack = new Stack();
        int answer = 0;

        for(int i=0;i<order.length;i++){
            queue.add(i+1);
        }

        for(int i=order.length-1;i>=0;i--){
            int priority = order[i];

            while(!queue.isEmpty()){
                if(queue.peek().equals(priority)){
                    queue.poll();
                    answer++;
                }else{
                    stack.add(queue.poll());
                }
            }

            if(stack.peek().equals(priority)){
                stack.pop();
                answer++;
            }            
        }
        return answer;
    }

    public static void main(String args[]){
        int[] array = {4,3,1,2,5};
        System.out.println(solution(array));
    }
}
