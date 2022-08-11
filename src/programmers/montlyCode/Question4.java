package programmers.montlyCode;

public class Question4 {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left;i<=right;++i){
            int temp = 0;

            for(int j=1;j<=i;++j){
                if(i%j==0) ++temp;
            }
            
            if(temp%2==0) answer += i;
            else answer -= i;
        }
        return answer;
    }

    public int solution2(int left, int right) {
        int answer = 0;
        for(int i=left;i<=right;++i){
            int temp = 0;

            for(int j=1;j<=i;++j){
                if(i%j==0) ++temp;
            }
            
            if(temp%2==0) answer += i;
            else answer -= i;
        }
        return answer;
    }
}
