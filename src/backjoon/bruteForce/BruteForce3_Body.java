package backjoon.bruteForce;

import java.util.Scanner;

public class BruteForce3_Body {
    public static void main(String args[]){        
        int[][] students = new int[5][3];
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=0;i<N;i++){
            students[i][0] = sc.nextInt();
            students[i][1] = sc.nextInt();
        }

        for(int i=0;i<students.length;i++){
            students[i][2] = 1;
            for(int j=0;j<students.length;j++){
                if(i!=j && students[i][0]<students[j][0] && students[i][1]<students[j][1]) {
                    students[i][2] += 1;
                }
            }
            System.out.print(students[i][2]+" ");
        }
        
        System.out.println();

    }
}
