package programmers.exam_test_3;

public class Question3_retry {
    public int solution(int distance, int[][] scope, int[][] times){
        int answer = distance;
        //distance = scope[i][0] || scope[i][1], 즉 감시 구간과, 해당 구간에 닿는 시간은 같음. 
        //scope[i][]의 구간이 감시 영역에 있는지 확인. = 구간 전체를 확인하는게 아니라, 감시영역의 구간만 확인 
        for(int i=0;i<scope.length;i++){
            for(int j=scope[i][0];j<=scope[i][1];j++){
                int momment = j % (times[i][0]+times[i][1]);

                if(0<=momment && momment<=times[i][0]) return answer = j; //근무 시간 : 0 <=k <=time[i][0], 휴식 시간 : times[i][0] <= k times[i][1];
            }
        }
        return answer;
    }


    public static void main(String args[]){
        Question3 s = new Question3();

//        int[][] array = {{7, 8}, {4, 6}, {11, 10}};
//        int[][] array2= {{2, 2}, {2, 4}, {3, 3}};
//        int n = 12; //기댓값 12

        int[][] array = {{3,4},{5,8}};
        int[][] array2 = {{2,5},{4,3}};
        int n = 10; //기댓값 8
        System.out.println(s.solution(n, array, array2));
    }
}
