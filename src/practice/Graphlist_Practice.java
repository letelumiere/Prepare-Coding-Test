package practice;

import java.util.ArrayList;
import java.util.List;
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

public class Graphlist_Practice {

	// 노드와 비용을 포함하는 객체를 미리 만들어준다.
	static public class Node {
		int end; // 연결되는 정점
		int cost; // 비용

		Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "[" + end + ", " + "" + cost + "]";
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// V = 정점의 개수, E = 간선의 개수.
		System.out.print("Vertex, Edge의 개수 입력 :");
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		System.out.println();
		// 1차원 리스트를 만든다.
		// 인덱스의 번호 = 노드의 번호 이기 때문에, 1차원 리스트의 크기를 임의로 1 늘려서 정의한다(스킬).
		List<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
		for (int i = 0; i < V + 1; i++) {
			graph.add(new ArrayList<Node>());
		}

		int a;
		int b;
		int cost;
		for (int i = 0; i < E; i++) {
			System.out.print("a, b, cost 입력 : ");
			a = sc.nextInt();
			b = sc.nextInt();
			cost = sc.nextInt();
			
			graph.get(a).add(new Node(b, cost));
			// 만일, 무향 그래프라면 반대의 상황도 추가해 준다.
			// graph.get(b).add(new Node(a, cost));
			System.out.println();
		}

		// 인접 행렬 출력
		System.out.println(graph);
		sc.close();
	}
}

