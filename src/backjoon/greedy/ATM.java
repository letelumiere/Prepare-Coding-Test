package backjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ATM {
    //최소합 도출
    //최적해는 가장 작은 단위에서 최적화된 계산을 전체로
    //그리디는 모든 경우에서의 답이 나오지는 않는다.
    //오름차순 정렬의 값이 있다면, 그 반대항도 체크해보자
    //Arrays.sort를 Reverse할 수도 있지만, 그건 좀 어렵고 하니깐 그냥 역순으로 반복문 돌리는게 편함

    public static int solution(int[] waitings){
        int answer = 0;
        
        Arrays.sort(waitings);
/*  내림차순 
        for(int j=waitings.length-1;j>=0;j--){
            for(int i=j;i<waitings.length;i++){
                answer += waitings[i];
            }
        }
*/
        for(int i=0;i<waitings.length;i++){
            for(int j=i;j>=0;j--){
                answer += waitings[j];
            }
        }
        return answer;
    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int[] array = new int[sc.nextInt()];

        for(int i=0;i<array.length;i++){
            array[i] = sc.nextInt();      
        }

        int result = solution(array);
        System.out.println(result);
    }
}
