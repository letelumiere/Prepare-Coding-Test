package backjoon.dfs;

public class DepthFirstSearch1 {
    boolean[] visited;
    
    public static void solution(){
    }


    public void dfs(int V, int E, int R){
        visited[R] = true;

        for(int i=0;i<R;i++){
            if(visited[i]==false) dfs(V,E,i);
        }

    }

    public static void main(String args[]){

    }
}

/*
dfs(V, E, R) {  # V : 정점 집합, E : 간선 집합, R : 시작 정점
    visited[R] <- YES;  # 시작 정점 R을 방문 했다고 표시한다.
    for each x ∈ E(R)  # E(R) : 정점 R의 인접 정점 집합.(정점 번호를 오름차순으로 방문한다)
        if (visited[x] = NO) then dfs(V, E, x);
}

 */