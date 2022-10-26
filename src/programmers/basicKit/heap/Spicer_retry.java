package programmers.basicKit.heap;

import java.util.*;

public class Spicer_retry {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int answer = 0;

        for(int i : scoville){
            queue.add(i);
        }

        while(queue.peek()<K){
            queue.offer(queue.poll()+(queue.poll()*2));
            if(queue.size()==1 && queue.peek()<K) answer = -1;
        }

        return answer;
    }    

}
