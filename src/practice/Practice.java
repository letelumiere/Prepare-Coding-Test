package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice {
    int[][] graph;
    int V, E;


    class Node{
        int end;
        int cost;
        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
        @Override
        public String toString() {
            return "Node [cost=" + cost + ", end=" + end + "]";
        }
    }

    public static void main(String args[]){
    }

    public void graph_list(int V, int E){
		Scanner sc = new Scanner(System.in);
        List<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
        
        for(int i=0;i<V+1;i++){
            graph.add(new ArrayList<Node>());
        }

        int a, b, cost;
        for(int i=0;i<E;i++){
            a = sc.nextInt();
            b = sc.nextInt();
            cost = sc.nextInt();

            graph.get(a).add(new Node(b, cost));
            //무향 그래프일 경우 반대의 경우 도 포함한다
            //graph.get(b).add(new Node(a, cost)); 
        }

        System.out.println(graph);
        sc.nextInt();
    }

    public void graph_matrix(int[][] graph, int V, int E){
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();   //vertex = 정점
        E = sc.nextInt();   //edge   = 간선
        graph = new int[V+1][V+1];

        int row, col, cost;
        for(int i=0;i<E;i++){
            row = sc.nextInt();
            col = sc.nextInt();
            cost = sc.nextInt();

            graph[row][col] = cost;
            //무향 그래프일 경우, graph[col][row] = cost 추가
        }

        for(int i=1;i<V+1;i++){
            for(int j=1;j<E+1;j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
