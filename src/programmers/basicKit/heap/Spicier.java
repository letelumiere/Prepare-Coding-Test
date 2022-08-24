package programmers.basicKit.heap;
import java.util.*;

public class Spicier {
    public int solution(int[] scoville, int K){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int answer = 0;
        
        for(int i : scoville){
            queue.add(i);
        }

        while(queue.peek()<K){
            queue.add(queue.poll()+queue.poll()*2);
            ++answer;

            if(queue.size()==1 && queue.peek()<K) return answer = -1;
        }

        return answer;
    }
}
