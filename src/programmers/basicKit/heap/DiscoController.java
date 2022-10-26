package programmers.basicKit.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DiscoController {
    public int solution(int[][] jobs) {
        Queue<int[]> q_queue = new LinkedList<>();
        PriorityQueue<int[]> p_queue = new PriorityQueue<>((o1,o2) -> o1[1]-o2[1]); //처리시간 오름차순 정렬
        int answer = 0;

        Arrays.sort(jobs, (o1, o2) -> o1[0]-o2[0]); //요청시간 오름차순 정렬
        for(int[] i : jobs){    //요청시간이 오름차순 정렬 된 순서대로 queue에 삽입
            q_queue.offer(i);
        }
        
        p_queue.offer(q_queue.poll());
        while(!q_queue.isEmpty() && !p_queue.isEmpty()){
            int[] n = p_queue.poll(); //해당 큐의 처리 내용
            answer += n[1];

            while(!q_queue.isEmpty()){
                int[] nj = q_queue.peek(); //다음 처리 내용을 비교
                
                if((n[0]<=nj[0] && nj[0]<=n[1]) || nj[0]>=n[1]) p_queue.offer(q_queue.poll());  //해당 처리가 진행되는 동안, 대기 가능한 처리를 우선순위에 삽입
                else break;
            }   
            
            int wait = 0;
            int delay = 0;
            while(!p_queue.isEmpty()){
                int[] nj = p_queue.poll();
                wait += n[1]-nj[0];
                delay += answer+nj[1];    
            }

            answer += delay+wait;
        }
        
        return answer/jobs.length;
    }

    public static void main(String args[]){
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        //int[][] jobs = {{7, 8}, {3, 5}, {9, 6}};
        DiscoController sol = new DiscoController();
        System.out.println(sol.solution(jobs));
    }
}
