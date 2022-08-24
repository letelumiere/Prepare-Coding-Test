package backjoon;

//백준 함수 유형 - 15596번 문제
public class SumOfIntegerN {
    public long solution(int[] a){
        long answer = 0;
        return answer;
    }

    public long sum(int[] array, int n, int idx){
        if(idx==array.length) return n;
        else {
            n += array[idx];
            return sum(array, n, idx);
        }
    }
}
