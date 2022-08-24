package backjoon.greedy;

public class Practice {
    
    public static int solution(int[] stations, int[] roads){
        int answer = 0;
        int idx = 0; int ptr = 0;
        int limit = stations.length-1;

        while(ptr!=limit){
            int cost = stations[idx]*roads[ptr];
            int compares = stations[ptr]*roads[ptr];

            if(cost<compares) answer += cost;
            else{
                answer += compares;
                idx = ptr;
            }
            ++ptr;
        }
        return answer;
    }

    public static int solution2(int[] stations, int[] roads){
        int answer = 0;
        int minCost = stations[0];

        for(int i=0;i<roads.length;i++){
            minCost = Math.min(minCost, stations[i]);
            answer += minCost*roads[i];
        }
        return answer;
    }

}
