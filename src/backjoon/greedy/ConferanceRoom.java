package backjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ConferanceRoom {
    public static int solution(int[][] schedules){
        int answer = 0;

		Arrays.sort(schedules, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) return o1[0] - o2[0];				
				return o1[1] - o2[1];
			}
		});
        
        int endTime = 0;
        for(int i=0;i<schedules.length;i++){
            int comp1 = schedules[i][0]; 
            int comp2 = schedules[i][1];

            if(endTime<=comp1) {
                ++answer;
                endTime = comp2;
            }   
        }
        return answer;
    }

    public static int solution2(int[][] schedules){
        int answer = 0;
        Arrays.sort(schedules, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]==o2[1] ? o1[0]-o2[0] : o1[1]-o2[1];
            }            
        });

        int endTime = schedules[0][0];
        for(int i=0;i<schedules.length;i++){
            int compare = schedules[i][0];
            
            if(endTime<=compare){
                ++answer;
                endTime = compare;
            }
        }
        return answer;
    }


    public static int solution_deprecated(int[][] schedules){
        int answer = 0;
        int[] array = new int[schedules.length];

        for(int i=0;i<schedules.length;i++){
            int beginTime = schedules[i][0];
            int endTime = schedules[i][1];

            int total = 0;
            for(int j=0;j<schedules.length;j++){
                if(i!=j){
                    int comp1 = schedules[j][0];
                    int comp2 = schedules[j][1];
            
                    if(comp1<beginTime && comp2<endTime) continue;
                    else if(comp1>=endTime || comp2<=endTime){
                        beginTime = comp1;
                        endTime = comp2;
                        ++total;
                    }    
                }
            }

            array[i] = total;
            answer = Math.max(array[i], answer);
        }

        return answer;
    }

    public static void main(String args[]) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][] array = new int[Integer.parseInt(br.readLine())][2];
        for(int i=0;i<array.length;i++){
            st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());

        }

        int result = solution(array);
        System.out.println(result);        

        br.close();
        bw.close();
    }
}

//https://ifuwanna.tistory.com


/*
 * 
Test case 1: result = 3;
3
1 1
2 2
3 3


 */