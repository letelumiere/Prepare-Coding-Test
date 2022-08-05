package backjoon.dynamicP;

import java.util.Scanner;

public class Dynamic3 {
    public static int cache[][][];
    public static int i = 0;
    /* 
    public static boolean inRange(int a,int b,int c){
        return (0 <= a && a <= 20) && (0 <= b && b <= 20) && (0 <= c && c <= 20);
    }
    
    public static int w(int a, int b, int c){
        if(inRange(a, b, c) && cache[a][b][c] != 0) return cache[a][b][c];
        i++;
        System.out.println(i+" : "+a+" "+b+" "+c);

        if(a<=0 || b<=0 || c<=0) return 1; 
        if(a>20 || b>20 || c>20) return cache[20][20][20] = w(20, 20, 20); 
        if(a<b && b<c) return cache[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c); 

        return cache[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }

    */

    public static boolean inRange(int a, int b, int c){
        return (a>0 || b>0 || c>0) && (a<=20 && b<=20 && c<20);
    }

    public static int w(int a, int b, int c){
        if(inRange(a,b,c) && cache[a][b][c]!=0) return cache[a][b][c];
        
        if(a<=0 || b<=0 || c<=0) return 1; 
        if(a>20 || b>20 || c>20) return cache[20][20][20] = w(20, 20, 20); //abc 중 하나가 20보다 크면 w(20,20,20);
                                                                                //변수의 최대값은 배열의 최대 범위에 저장

        if(a<b && b<c) return cache[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c); //a가 b보다 작고, b가 c보다 작으면 ~~ 
                                                                                            //재귀 호출 시, 출력값은 해당 주소에 저장
        return cache[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1); //재귀호출 시, 출력값은 해당 주소에 저장
    }

    public static void main(String args[]){        
        cache = new int[21][21][21];         
        System.out.println(w(2, 2, 2)); //4
        System.out.println(w(10, 4, 6)); //523
        System.out.println(w(50, 50, 50)); //1048576
        System.out.println(w(-1, 7, 18)); //1
    }
}

/*
 * 
 * 2021.01.02 일 쯤 기점으로 동적계획법 1 카테고리 중 문제 하나가 새로 업데이트 된 문제다. 
 * 아마 동적계획법에 대해 많이 어려워 하기 때문에 함수는 이미 구현해놓고 
 * 가장 중요한 메모이제이션을 활용하는 법을 알 수 있도록 돕는 것에 아주 적절한 문제인 것 같다.

앞으로는 함수를 구현해야 할 텐데, 그리 어렵지 않다.
동적계획법 문제를 풀기위한 가장 기본 단계 3개만 알고있으면 된다.


1. 점화식 찾기 (동적계획법의 핵심은 반복되는 계산을 줄이는 것이기 때문에 대부분 점화식으로 표현이 가능하다.)
2. 점화식에서 반복되는 수식 확인하기 
3. 점화식을 재귀식으로 옮기면서 반복되는 수식은 메모리에 저장하기 (재귀 말고 반복문으로도 변환이 가능하지만, 일단은 재귀로 옮기는 연습부터 하는 것을 추천한다.)

위 3가지 과정을 거치면 대부분 완벽하게까진 아니더라도 동적계획법 방식으로 문제를 해결 할 수 있다.
만약 어렵거나 이해가 되지 않은 부분이 있다면 언제든 댓글 남겨주시면 최대한 빠르게 답변드리겠다.


 */