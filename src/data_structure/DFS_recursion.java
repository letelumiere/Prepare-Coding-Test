package data_structure;

//같이보기 https://codingnojam.tistory.com/44
public class DFS_recursion {
    //방문 처리에 사용할 배열 선언(dp) 
    static boolean[] visited = new boolean[9];
	
    //그래프의 연결 상태를 2차원 배열로 표현 (어디까지나 예시.)
    //index가 각각의 node번호가 될 수 있게 0번 index는 아무것도 없는 상태로 가정
    static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

    public static void main(String[] args){
        dfs(1);
    }


    static void dfs(int nodeIndex){
        //방문 처리
        visited[nodeIndex] = true;

        //방문 노드 출력
        System.out.print(nodeIndex+" => ");

        //방문한 노드의 인접한 노드 찾기
        for(int node : graph[nodeIndex]){

            //인접한 노드가 방문한 적이 없다면 재귀로 DFS 수행
            if(!visited[node]) dfs(node);
        }
    }
}

