package programmers.montlyCode;

public class Question7 {
    public long solution(int price, int money, int count) {
        long answer = 0;

        for(int i=1;i<=count;++i){
            price += price*i;
        }

        return answer<price ? Math.abs(answer-price) : 0 ;
    }
}
