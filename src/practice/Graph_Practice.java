package practice;

import java.util.Scanner;

/*
정점, 간선의 개수 이후
(노드, 노드, 비용)이 주어진 경우
5 6
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
 */

public class Graph_Practice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// V = 정점의 개수, E = 간선의 개수.
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		// 2차원 배열(인접 행렬)을 만든다.
		// 인덱스의 번호 = 노드의 번호 이기 때문에, 2차원 배열의 크기를 임의로 1 늘려서 정의한다(스킬).
		int[][] graph = new int[V + 1][V + 1];
		
		int row;
		int col;
		int cost;
		for(int i = 0; i < E; i++) {
			row = sc.nextInt();
			col = sc.nextInt();
			cost = sc.nextInt();
			graph[row][col] = cost;
			// 만일, 무향 그래프라면 반대의 상황도 추가해 준다.
			// graph[col][row] = cost;
		}
		
		// 인접 행렬 출력
		for(int i = 1; i < V + 1; i++) {
			for(int j = 1; j < V + 1; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}


