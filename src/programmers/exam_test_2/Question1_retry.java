package programmers.exam_test_2;

public class Question1_retry {

    public int solution(int[] number) {
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



    public static void main(String args[]){
        Question1_retry s = new Question1_retry();
        int[] array = {-2,3,0,2,-5};
        
        System.out.println(s.solution(array));

    }
}
