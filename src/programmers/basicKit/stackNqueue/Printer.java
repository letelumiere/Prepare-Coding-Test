package programmers.basicKit.stackNqueue;

import java.util.*;

public class Printer {
    public int solution(int[] priorities, int location){
        Queue<Paper> queue = new ArrayDeque<>();

        for(int i=0;i<priorities.length;++i){
            Paper p = new Paper(priorities[i]);

            if(i==location) p.check = true;
            queue.add(p);
        }

        Arrays.sort(priorities);
        
        int ptr = priorities.length-1;
        int answer = 1;
        while(!queue.isEmpty()){
            Paper p = queue.poll();

            if(p.priority==priorities[ptr]){
                if(p.check) return answer;
                ++answer;
                --ptr;
            }else{
                queue.add(p);
            }
        }
        
        return answer;
    }

}

class Paper{
    int priority;
    boolean check;

    Paper(int priority){
        this.priority = priority;
        this.check = false;
    }
}
