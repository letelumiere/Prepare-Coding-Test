package programmers.exam_test_3;

public class Question1 {

    public int solution(int a, int b, int n) { // 30분 소요
        int answer = 0;

        while(n>=a){
            int j = (n/a)*b;
            n = (n%a)+j;  

            answer += j;
        }

        return answer;
    }

    public static void main(String args[]){
        Question1 s = new Question1();
        //int[] topping = {1, 2, 3, 1, 4}; //result 0
        //       int[] topping = {1, 2, 1, 3, 1, 4, 1, 2}; //result 2
     //System.out.println(solution(topping));
    }
}
