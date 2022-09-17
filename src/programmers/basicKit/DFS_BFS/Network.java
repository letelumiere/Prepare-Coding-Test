package programmers.basicKit.DFS_BFS;

public class Network {
    public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean[] visited = new boolean[n];
            for(int i=0;i<n;i++) {
                if(!visited[i]) {   //해당 node를 재귀 호출 하기 전에, 이전 절차에서 이미 방문 했는지 = network 연결이 됐는지
                    dfs(i, computers, visited); //network 연결이 안됐으므로 dfs
                    answer++;   //해당 node가 방문 안됐으면, 따로 분리된 node이므로 answer++;
                }
            }
            return answer;
        }
    
    public void dfs(int startNode, int[][] computers, boolean[] visited) {
        visited[startNode] = true;
        for(int i=0;i<computers.length;i++) {
            if(!visited[i] && computers[startNode][i]==1) dfs(i, computers, visited);
        }
    }

}
