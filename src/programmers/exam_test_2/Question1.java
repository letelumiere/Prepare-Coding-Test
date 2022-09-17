package programmers.exam_test_2;

public class Question1 {
    public int solution(int[] number) {  //17분 소요
        int answer = 0;
        for(int i=0;i<number.length-2;i++){
            for(int j=i+1;j<number.length-1;j++){
                for(int k=j+1;k<number.length;k++){
                    int sum = number[i]+number[j]+number[k];
                    if(sum==0) answer++;
                }
            }
        }
        return answer;
    }
}
