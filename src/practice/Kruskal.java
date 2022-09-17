package practice;

import java.util.Arrays;
import java.util.Scanner;

/*
sample input(첫 줄의 첫 숫자는 정점의 개수, 두 번째 숫자는 간선의 개수).
6 9
1 6 5
2 4 6
1 2 7
3 5 15
5 6 9
3 4 10
1 3 11
2 3 3
4 5 7
 */

public class Kruskal {
	static int V, E;
	static int[][] graph;
	static int[] parent; // 각 노드의 부모
	static int final_cost; // 최종적으로 연결된 최소 신장 트리 연결 비용.

	public static void main(String[] args) {
		// 그래프의 연결상태(노드1, 노드2, 비용)를 초기화.
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		graph = new int[E][3];
		for (int i = 0; i < E; i++) {
			graph[i][0] = sc.nextInt();
			graph[i][1] = sc.nextInt();
			graph[i][2] = sc.nextInt();
		}
		parent = new int[V];
		final_cost = 0;

		// 간선 비용 순으로 오름차순 정렬
		Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));

		// makeSet
		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}
		// 낮은 비용부터 크루스칼 알고리즘 진행
		for (int i = 0; i < E; i++) {
			// 사이클이 존재하지 않는 경우에만 간선을 선택한다(여기서는 최종 비용만 고려하도록 하겠다).
			if (find(graph[i][0] - 1) != find(graph[i][1] - 1)) {
				System.out.println("<선택된 간선>");
				System.out.println(Arrays.toString(graph[i]));
				union(graph[i][0] - 1, graph[i][1] - 1);
				final_cost += graph[i][2];
				System.out.println("<각 노드가 가리키고 있는 부모>");
				System.out.println(Arrays.toString(parent) + "\n");
				continue;
			}
		}
		
		System.out.println("최종 비용 : " + final_cost);
		sc.close();
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
	
        if (a > b) parent[a] = b;
		else parent[b] = a;
	}

	private static int find(int x) {
		if (parent[x] == x) return x;
		else return find(parent[x]);
	}
}