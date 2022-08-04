package backjoon.bruteForce;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BruteForce2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1;i<=n;i++){
            int k = i;
            int total = 0;

            while(k>0){
                total += k%10;
                k = k/10;
            }
            
			if(total+i==n) {
                System.out.println(i);
				break;
			}
        }   
    }
}