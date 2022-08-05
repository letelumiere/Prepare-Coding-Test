package backjoon.dynamicP;
import java.util.Scanner;

public class Dynamic7 {




    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int houses[][] = new int[N+1][3];
        int costs[][] = new int[N+1][3];

        for(int i=1;i<=N;i++){
            for(int j=0;j<3;j++){
                houses[i][j] = sc.nextInt();
            }
        }

        for(int i=1;i<=N;i++){
            costs[i][0] = houses[i][0] + Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] = houses[i][1] + Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] = houses[i][2] + Math.min(costs[i-1][0], costs[i-1][1]);
            
        }

        System.out.println(Math.min(Math.min(costs[N][0], costs[N][1]), costs[N][2]));
    }
}
/* 

d[i][0] = Min(d[i-1][1], d[i-1][2]) + a[i][0];
d[i][1] = Min(d[i-1][0], d[i-1][2]) + a[i][1];
d[i][2] = Min(d[i-1][0], d[i-1][1]) + a[i][2];
여기서 사용된 Min은 최솟값을 구하는 메소드(또는 함수)로 아래와 같다.

public static int Min(int a, int b){ return a < b ? a : b; }
*/
//1번 집의 색은 2번 집의 색과 같지 않아야 한다. N1 != N2
//N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.   N != N-1

//i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.  i(2 ≤ i ≤ N-1) != i-1, i+1
// 최솟값 = Math.min();
/* 
3
26 40 83
49 60 57
13 89 99

RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.

입력
첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.

*/