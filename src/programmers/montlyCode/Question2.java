package programmers.montlyCode;

import java.util.ArrayList;

public class Question2 {

        //45->1200->2100->7
        public int solution(int n) {
            int answer = 0;
            String str = "";

            while(n!=0){
                str += n%3;
                n = n/3;
            }

            System.out.println(str);

            return answer = Integer.parseInt(str, 3);
        }
    }
