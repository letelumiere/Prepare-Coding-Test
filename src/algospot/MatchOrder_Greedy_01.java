package algospot;

import java.util.*;

public class MatchOrder_Greedy_01 {
    static int[][] schedules;
    static int[] result;

    public static int solution(Integer[] rus, Integer[] kor){
        ArrayList<Integer> klist = new ArrayList<>();
        int answer = 0;

        for(int i=0;i<kor.length;i++) {
            klist.add(kor[i]);
        }

        for(int i=0;i<rus.length;i++){
            int first = 0; 
            int last = klist.size()-1;

            if(rus[i]>klist.get(first)) klist.remove(last);  //어떤 팀을 동원해도 질 경우
            else{ //이길 수 있는 팀이 있을 경우
                int k = last;
                while(k>=0){
                    if(klist.get(k)>=rus[i]){
                        klist.remove(k);
                        ++answer;
                        break;
                    }
                    --k;
                }
            }
        }
        return answer;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();   //테스트 케이스 회수.
        
        int[] result = new int[c];
        for(int i=0;i<c;i++){
            int n = sc.nextInt();   //출전 경기 회수.

            schedules = new int[2][n];
            for(int j=0;j<n;j++) schedules[0][j] = sc.nextInt();
            for(int j=0;j<n;j++) schedules[1][j] = sc.nextInt();

            Integer[] rus = Arrays.stream(schedules[0]).boxed().toArray(Integer[]::new);
            Arrays.sort(rus, Comparator.reverseOrder());
            Integer[] kor = Arrays.stream(schedules[1]).boxed().toArray(Integer[]::new);
            Arrays.sort(kor, Comparator.reverseOrder());
            
            result[i] = solution(rus, kor);
        }

        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
        
    }
}
