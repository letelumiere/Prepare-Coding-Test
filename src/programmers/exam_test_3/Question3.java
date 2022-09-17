package programmers.exam_test_3;

public class Question3 { //index 문제로 1시간 이상 소요....
    public int solution(int distance, int[][] scope, int[][] times) {
        boolean[] route = new boolean[distance+2];
        int answer = 0;

        for(int i=0;i<scope.length;i++){
            int rangeMin = scope[i][0];
            int rangeMax = scope[i][1];
            int shift = times[i][0]+times[i][1];

            for(int j=rangeMin;j<=rangeMax;j++){
                int timing = j%shift;
                
                if(timing>0 && timing<=times[i][0]) route[j+1] = true;
            }
        }

        for(int i=1;i<route.length-1;i++){
            if(route[i]==false) answer++;
            else break;
        }

        return answer;
    }
    public static void main(String args[]){
        Question3 s = new Question3();

        int[][] array = {{7, 8}, {4, 6}, {11, 10}};
        int[][] array2= {{2, 2}, {2, 4}, {3, 3}};
        int n = 12; //기댓값 12

//        int[][] array = {{3,4},{5,8}};
//        int[][] array2 = {{2,5},{4,3}};
//        int n = 10; 기댓값 8
        System.out.println(s.solution(n, array, array2));
    }
}
