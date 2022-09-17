package backjoon.greedy;

import java.util.*;
import java.io.*;

public class Greedy_RoadTrip {
    public static long solution(long[] stations, long[] roads){
        long answer = 0;
        int idx = 0; int ptr = 0;
        long limit = stations.length-1;

        while(ptr!=limit){
            long cost = stations[idx]*roads[ptr];
            long compares = stations[ptr]*roads[ptr];

            if(cost<compares) answer += cost;
            else{
                answer += compares;
                idx = ptr;
            }
            ++ptr;
        }
        return answer;
    }

    public static long solution2(long[] stations, long[] roads){
        long answer = 0;
        long minCost = stations[0];

        for(int i=0;i<roads.length;++i){
            if(minCost>stations[i]) minCost = stations[i];
            answer += minCost*roads[i];
        }

        return answer;
    }
    
    public static int solution3(int[] stations, int[] roads){
        int answer = 0;
        int minCost = stations[0];

        for(int i=0;i<roads.length;i++){
            minCost = Math.min(minCost, stations[i]);
            answer += minCost*roads[i];
        }
        return answer;
    }


    public static void main(String args[]) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] roads = new long[N-1];
        long[] stations = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<roads.length;++i){
            roads[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<stations.length;++i){
            stations[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(stations, roads));

        br.close();
        bw.close();
    }
}