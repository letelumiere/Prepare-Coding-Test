package programmers.basicKit.stackNqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Develops_retry {
    public int[] solution(int[] progresses, int[] speeds){
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> blist = new ArrayList<>();

        for(int i=0;i<progresses.length;i++){
            int num = 100-progresses[i];
            int spendTime = num/speeds[i];

            if(num%speeds[i]>0) ++spendTime;
            queue.add(spendTime);
        }

        int standard = queue.poll();
        int proceed = 1;
        while(!queue.isEmpty()){
            int front = queue.poll();

            if(standard>=front) proceed++;
            else{
                blist.add(proceed);
                standard = front;
                proceed = 1;
            }

            if(queue.isEmpty()) {
                blist.add(proceed);
                break;
            }
        }

        int[] answer = new int[blist.size()];
        for(int i=0;i<answer.length;++i){
            answer[i] = blist.get(i);
        }

        return answer;
    }


}
