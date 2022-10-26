package programmers.beginnerKit;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Day123 {
    public int solution1_sum(int num1, int num2) {
        return num1+num2;
    }

    public int solution1_subtraction(int num1, int num2) {
        return num1-num2;
    }
    
    public int solution1_multiply(int num1, int num2) {
        return num1*num2;
    }
    
    public int solution1_divide(int num1, int num2) {
        return num1/num2;
    }
    
    public int solution2_divide(int num1, int num2) {
        int answer = (num1*1000)/num2;
        return answer;
    }
    public int solution2_compare(int num1, int num2) {
        return num1==num2 ? 1 : -1;
    }

    //일반적 풀이
    public int[] solution2_sumOfFraction(int denum1, int num1, int denum2, int num2) {
        int[] answer = new int[2];

        if(num2%num1==0){
            int num = num2/num1;
            answer[0] = (denum1*num)+denum2;
            answer[1] = num2;
        }else{
            int num = num1*num2;
            answer[0] = (denum1*num2)+(denum2*num1);
            answer[1] = num;
        }

        return answer;
    }

    //BigInteger 메서드 사용. gcd = 최대공약수 lcm = 최소공배수
    public static int[] solution2_SumOfFraction(int denum1, int num1, int denum2, int num2) {
		int gcd = gcd(num1, num2); // 입력받은 두 분모의 최대공약수를 구한다.
		int lcm = lcm(num1, num2); // 입력받은 두 분모의 최소공배수를 구한다.
        
        // 분모에 어떤 수를 곱해야 최소공배수가 나오는지 확인한 후 분자를 분모에 맞춰준다.
		int mul1 = lcm / num1;
		denum1 *= mul1;
		int mul2 = lcm / num2;
		denum2 *= mul2;
        
		int denum = denum1 + denum2; // 두 분자를 더한다.
		int gcd2 = gcd(denum, lcm); // 기약분수를 구해야 하므로, 합한 분자와 분모의 최대공약수를 구한다.
		int[] answer = {denum / gcd2, lcm / gcd2}; // 최대공약수로 나눠준다.

        return answer;
    }
    
    // 최대공약수 - 유클리드 호제법
    public static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
    
    // 최소공배수
    public static int lcm(int a, int b){
        if(b==0) return a;
        return a*b/gcd(a,b);
    }

    //배열 두 배로 만들기
    public int[] solution2_doubleArray(int[] numbers) {
        int[] answer = numbers.clone();
        for(int i=0;i<answer.length;i++){
            answer[i] = answer[i]*2;
        }
        return answer;
    }

    //나머지 구하기
    public int solution3_reminder(int num1, int num2) {
        return num1%num2;
    }

    public int solution3_centerNum(int[] array) {
        Arrays.sort(array);
        return array[array.length/2];
    }

    public int solution3_maximumRationNumber(int[] array) {
        HashMap<Integer, Integer> hMap = new HashMap();
        int answer = 0;
        
        for(int i=0;i<array.length;i++){
            hMap.put(array[i], hMap.getOrDefault(array[i], 0)+1);
        }

        int temp = 0;
        for(int i : hMap.keySet()){
            if(temp<hMap.get(i)){
                temp = hMap.get(i);
                answer = i;
            }
        }
        
        for(int i : hMap.keySet()){
            if(answer!=i && temp==hMap.get(i)) return -1;
        }
    
        return answer;
    }

    public int[] solution3_iHateEven(int n) {
        ArrayList<Integer> alist = new ArrayList();
        for(int i=1;i<=n;i++){
            if(i%3==0) alist.add(i);
        }

        int[] answer = new int[alist.size()];
        for(int i=0;i<alist.size();i++){
            answer[i] = alist.get(i);
        }
        
        Arrays.sort(answer);
        return answer;
    }
}
