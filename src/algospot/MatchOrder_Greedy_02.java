package algospot;

import java.io.*;
import java.util.*;

public class MatchOrder_Greedy_02 {
    static int[] result;
    static PriorityQueue<Integer> rus;
    static PriorityQueue<Integer> kor;


    public static int solution(PriorityQueue<Integer> rus, PriorityQueue<Integer> kor){
        Queue<Integer> queue = new LinkedList();
        int answer = 0;


        while(!rus.isEmpty()){
            int r = rus.poll();
            int last = kor.size()-1;
            if(r>kor.peek()) kor.remove(last);
            else{
                queue.add(kor.poll());
                while(true){
                    if(queue.peek()>=r) queue.add(kor.poll());
                    else while(queue.size()>1) kor.add(queue.poll());
                    queue.remove();   
                    ++answer;

                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] result = new int[Integer.parseInt(br.readLine())];
        for(int i=0;i<result.length;i++){
            rus = new PriorityQueue<>(Collections.reverseOrder());
            kor = new PriorityQueue<>(Collections.reverseOrder());
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) rus.add(Integer.parseInt(st.nextToken(" ")));
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) kor.add(Integer.parseInt(st.nextToken(" ")));

            result[i] = solution(rus, kor);
        }

        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }

        bw.close();
        br.close();
    
    }
}