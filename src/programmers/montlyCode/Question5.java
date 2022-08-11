package programmers.montlyCode;

import java.util.Arrays;

public class Question5 {

    public int solution(int[] numbers) {
        int answer = 45;    //1~9의 총합
        for(int i=0;i<numbers.length;++i){
            answer -= numbers[i];
        }
        
        return answer;
    }
}
