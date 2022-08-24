package codeUp.basic_important;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Basic1172 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int i1 = sc.nextInt();
        int i2 = sc.nextInt();
        int i3 = sc.nextInt();
        
        int[] arr = new int[3];
        arr[0] = i1;
        arr[1] = i2;
        arr[2] = i3;

        Arrays.sort(arr);

        // 배열 정렬은 Comparator 정의하여 사용.
        // 하지만 Collections클래스의 메서드를 상속하여 간단하게 사용 가능.
        // Arrays.sort(arr, Collections.reverseOrder());
        // 단, 이때는 자료형이 아닌 generics 클래스 객체 배열로 가능
        // 예 int => Integer

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
