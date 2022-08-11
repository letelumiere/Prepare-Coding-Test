package programmers.montlyCode;

public class Question6 {
    public int solution(int n) {
        int answer = n-1;
        
        for(int i=n-1;i>0;--i){
            if(i%n==1) answer = Math.min(answer, i);
            
        }


        return answer;
    }
}
