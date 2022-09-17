package backjoon.backTracking;

import java.util.*;

public class NandM_1 {
    static boolean[] visited;
    static int[] array;


    public static void dfs(int N, int M, int depth){
        if(depth==M){
            for(int i=0;i<array.length;i++){
                System.out.print(array[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                array[depth] = i+1;
                dfs(N, M, depth+1);
                visited[i] = false;
            }
        }

    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        visited = new boolean[N];
        array = new int[M];

        dfs(N, M, 0);
        
    }
}

/* 
boolean[] visit = new boolean[N];
int[] arr = new int[M];

public static void dfs(int N, int M, int depth) {
	// 재귀 깊이가 M과 같아지면 탐색과정에서 담았던 배열을 출력
	if (depth == M) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
		return;
	}


	for (int i = 0; i < N; i++) {
		// 만약 해당 노드(값)을 방문하지 않았다면?
		if (visit[i] == false) {
			
			visit[i] = true;		// 해당 노드를 방문상태로 변경
			arr[depth] = i + 1;		// 해당 깊이를 index로 하여 i + 1 값 저장
			dfs(N, M, depth + 1);	// 다음 자식 노드 방문을 위해 depth 1 증가시키면서 재귀호출
            
			// 자식노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
			visit[i] = false;
		}
	}
	return;
}
*/