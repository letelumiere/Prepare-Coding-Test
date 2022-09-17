package programmers.exam_test_3;

public class Question1_retry {
    public int solution(int a, int b, int n){
        int answer = 0;

        while(n<a){
            answer += (n/a)*b;
            n = (n/a)*b + (n%a);
        }
        return answer;
    }
}
