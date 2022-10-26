package programmers.basicKit.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int x;
    int y;
    int cost;

    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

}

public class GameMap_retry {
    int[][] forward = {{0,1},{1,0},{-1,0},{0,-1}};
    boolean[][] visited;

    public int solution(int[][] maps) {
        Queue<Node> queue = new LinkedList();
        visited = new boolean[maps.length][maps[0].length];
        int answer = 0;

        queue.offer(new Node(0, 0, 1));
        visited[0][0] = true;
        maps[0][0] = 1;
        bfs(queue, maps);

        
        
        return answer;
    }

    public int bfs(Queue<Node> queue, int[][] maps){
        int result = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.x==maps.length && node.y==maps[0].length){
                result = node.cost;
                break;
            }

            for(int i=0;i<forward.length;i++){
                int nx = node.x+forward[i][0];
                int ny = node.y+forward[i][1];
                int ncost = node.cost+1;

                if((0<=nx && nx<maps.length) && (0<=ny && ny<maps.length)){
                    if(maps[nx][ny]==1) {
                        visited[nx][ny] = true;
                        maps[nx][ny] = ncost;
                        
                        queue.offer(new Node(nx, ny, ncost));
                    }
                }
            }
            
        }
        return result;
    }


}
