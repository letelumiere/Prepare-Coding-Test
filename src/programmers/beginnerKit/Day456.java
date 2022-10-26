package programmers.beginnerKit;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Day456 {
    public double solution4_avgOfArray(int[] numbers) {
        double answer = 0;
        for(int i : numbers) answer += (double)i;
        return answer /= numbers.length*10;
    }

    public int solution4_dividePizza1(int n){
        return n%7 == 0 ? n/7 : (n/7)+1;
    }

    public int solution4_dividePizza2(int n) {
        int answer = n;
        while(answer%6!=0){
            answer += n;
        }
        return answer/6;
    }

    //최대 공약수를 Euclid 호제법으로 재귀 함수로 돌린 뒤 최소 공배수를 알아낸 뒤, 6나눔 
    public int solution4_dividePizza2_retry(int n) {
        int answer = lcm(6, n);
        return answer/6;
    }
    public int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
    public int lcm(int a, int b){
        if(b==0) return a;
        return (a*b)/gcd(a,b);
    }

    public int solution4_dividePizza3(int slice, int n) {
        return n%slice == 0 ? n/slice : n/slice+1;
    }

    public String solution6_StringReverse(String my_string) {
        StringBuffer answer = new StringBuffer(my_string);
        return answer.reverse().toString();
    }
    
    public int solution4_Germ1(int n, int t) {
        int answer = n;
        for(int i=1;i<=t;i++) answer *= 2;
        return answer;
    }
    public int solution4_Germ2(int n, int t) {
        return (int)Math.pow(2,t)*n;
    }

    
    public String solution(String my_string, String letter) {
        String answer = my_string.replaceAll("^f", "");

        return answer;
    }


    public static void main(String args[]){

    }
}
