package programmers.basicKit.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class MakeAMax {
    public static String solution(String number, int k) {
        String answer = "";

        for(int i=0;i<number.length();i++){
            if(k>0){
                int max = number.charAt(i);

                for(int j=i;j<=i+k;j++){
                    max = Math.max(number.charAt(j), max);
                }
                if(number.charAt(i)>=max) answer += number.charAt(i);
                else k--;
            }else{
                answer += number.charAt(i);
            }
        }

        return answer;
    }

    public static String solution2(String number, int k) {
        Stack<Character> stack = new Stack();
        String answer = "";

        for(int i=0;i<number.length();i++){
            char n = number.charAt(i);

            if(k==0 ||stack.isEmpty()) {
                stack.add(n);
            }else{
                while(true){
                    if(k==0 || stack.isEmpty() || stack.peek()>=n) break;
                    stack.pop();
                    k--;
                }
                stack.add(n);
            }

        }

        if(k>0) stack.pop();

        while(!stack.isEmpty()){
            answer += stack.pop();
        }

        return new StringBuffer(answer).reverse().toString();
    }

    public static void main(String args[]){
        System.out.println(solution2("4177252841", 4));
    }
}
