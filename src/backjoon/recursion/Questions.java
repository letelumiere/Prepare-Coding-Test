package backjoon.recursion;

import java.util.Scanner;

public class Questions {
    //문제 피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
    //n=17일때 까지 피보나치 수를 써보면 다음과 같다.
    public static int fibonacci(int n){
        if(n>=2) return fibonacci(n-1) + fibonacci(n-2); //이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
        else return n;  //if(n==0||n==1) return n;   <-   0번째 피보나치 수는 0이고 if(n==0) return n, 1번째 피보나치 수는 1이다. if(n==1) return 
    }


    //SuperSum  함수는 다음과 같이 정의된다.
    //SuperSum(0,n)=n (n은  모든 양의 정수)
    //SuperSum(k,n)=SuperSum(k−1,1)+SuperSum(k−1,2)+...+SuperSum(k−1,n)
    //k와 n이 여러개 주어진다. SuperSum의 값을 각각 출력하시오.
    //k = 0, n =3 이면, 합은 3
    //k = 1, n = 3 일떄, superSum(1,3) = superSum(1-1,1) + superSum(1-1,2) +... +superSum(1-1,3) ?? = 6??
    static int sum = 0;
    public static int superSum(int k, int n){        
        return sum;
    }

 

    //참고 https://st-lab.tistory.com/96
    //알고리즘 외우는 것 자체도 자체지만 추론 하는 법을 익혀야 함.
    public static void hanoi(int n, int start, int middle, int end){
        if(n==1) {
            System.out.println(start+" "+end);
            return;
        }
        hanoi(n-1, start, end, middle);
        System.out.println(start+" "+end);
        hanoi(n-1, middle, start, end);
    }
    public static void hanoii(int n, int start, int middle, int end){
        if(n==1) return;
        System.out.println("check "+(n-1)+" "+start+" "+end+" "+middle);
        hanoii(n-1, start, end, middle);
        System.out.println("check "+(n-1)+" "+middle+" "+start+" "+end);
        hanoii(n-1, middle, start, end);
    }   

    public static void triangle(int n){
        
        System.out.print("*");
    }

    public static void rt(int n){
        if(n==0) System.out.println();
    }

    public static void stars(int n){
        if(n==0) return;

            
    }


    public static void main(String args[]){
        int result = superSum(3, 3);
        System.out.println(result);
    }
}
