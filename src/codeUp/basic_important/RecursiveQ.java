package codeUp.basic_important;

import java.util.Scanner;

public class RecursiveQ {

    //q1901 (재귀 함수) 1부터 n까지 출력하기
    public static void increase(int n){
        if(n==0) return;
        else{
            increase(n-1);
            System.out.println(n);    
        }
    }
    
    //q1902 (재귀 함수) 1부터 n까지 역순으로 출력하기
    public static void decrease(int n){
        if(n==0) return;
        else{
            System.out.println(n);
            decrease(n-1);
        }
    }

    //1904 : (재귀함수) 두 수 사이의 홀수 출력하기
    public static int diff(int a, int b){
        if(a%2>0) System.out.println(a);

        if(a==b) return a;
        else return diff(a+1, b);
    }


    //점화식이란 무엇인가? (예시)
    public static int q1905_a(int n){
        if(n<=1) return 1;
        return q1905_a(n-1) + n;
    }

    //q1905
    public static int q1905(int n){
        if(n<=1) return 1;
        else{
            System.out.println(n);
            return q1905(n-1) + n;
        }
    }

    //q1916 

    //n!=n×(n−1)×(n−2)×⋯×2×1
    //즉, 5!=5×4×3×2×1=120 이다.
    public static int factorial(int n){
        if(n<=1) return n;
        return factorial(n-1) * n;
    }

    //q1915 fibonacci - 앞의 두 수를 더하여 나오는 수열

    public static int fibonacci(int n){
        if(n<=1) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }    

    //Q1920 - 10진수를 2진수로 변환하는 방법 = 10진수를 반복해서 2로 나눈 나머지를 입력
    public static void convertBinary(int n){
        if(n==0) return;
        convertBinary(n/2);
        System.out.print(n%2);
    }

    //Q1928 우박수 (3n+1) 
    /*
     * 콜라츠의 추측, 3n+1 문제, 우박수 문제라고 불리는 이 문제는 다음과 같다.
    1, 어떤 자연수 n이 입력되면,
    2. n이 홀수이면 3n+1을 하고,
    3. n이 짝수이면 n/2를 한다.
    4. 이 n이 1이 될때까지 2 3과정을 반복한다.

    예를 들어 5는 5 → 16 → 8 → 4 → 2 → 1 이 된다.
    이 처럼 어떤 자연수 n이 입력되면 위 알고리즘에 의해 1이 되는 과정을 모두 출력하시오.
     * 
     * 
     */
    public static void veritasium(int n){
        System.out.print(n+" ");
        if(n==1) return;
        if(n%2==0){
            veritasium(n/2);
        }else{
            veritasium(3*n+1);
        }
    }

    ///Q1929 우박수 역순 출력
    //재귀함수의 역은 출력->재귀함수 호출에서 재귀함수 호출->출력 순서로 바꾸면 된다?
    public static void veritasiumReverse(int n){
        //???
    }


    //SuperSum  함수는 다음과 같이 정의된다.
    //SuperSum(0,n)=n (n은  모든 양의 정수)
    //SuperSum(k,n)=SuperSum(k−1,1)+SuperSum(k−1,2)+...+SuperSum(k−1,n)
    //k와 n이 여러개 주어진다. SuperSum의 값을 각각 출력하시오.
    //k = 0, n =3 이면, 합은 3
    //k = 1, n = 3 일떄, superSum(1,3) = superSum(1-1,1) + superSum(1-1,2) +... +superSum(1-1,3) ?? = 6??

    public static int superSum(int k, int n){
        int sum = 0;
        System.out.println(k+" "+n);
        if(k==0) return n;
        for(int i=1;i<=n;i++) sum += superSum(k-1, i);
        return sum;
    }


    public static void triangle(int n){
        if(n==0) return;
        triangle(n-1);
        for(int i=0;i<n;i++) {
            System.out.print("*");
        }
        System.out.println();
    }


    //??
    public static void triangleReverse(int n){
        if(n==0) return;
        for(int i=0;i<n;i++){
            System.out.print("*");
        }
        System.out.println();

        triangle(n-1);

    }

    public static void main(String args[]){
        int k = 4;
        int n = 10;
        int[][] array = new int[k][n];
        int result = superSum(3,3);
        System.out.println(result);
    }
}
