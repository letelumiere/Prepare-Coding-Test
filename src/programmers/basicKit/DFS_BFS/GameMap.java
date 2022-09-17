package programmers.basicKit.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class GameMap {
    public static int solution(int[][] maps) {
        Queue<Nodes> queue = new LinkedList();
        int[][] direction = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int answer = -1;

        queue.offer(new Nodes(0, 0, 1));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Nodes node = queue.poll();
            int x = node.x;
            int y = node.y;
            int cost = node.cost;

            if(node.x==maps.length-1 && node.y==maps[0].length-1) {
                answer = cost;
                break;
            }

            for(int i=0;i<direction.length;i++){
                int dx = direction[i][0] + x;
                int dy = direction[i][1] + y;
                int dcost = cost+1;
                
                if(dx<0 || dx>=maps.length || dy<0 || dy>=maps[0].length) continue;
                if(!visited[dx][dy] && maps[dx][dy]==1) {
                    queue.offer(new Nodes(dx, dy, dcost));
                    visited[dx][dy] = true;
                }
            }
        }
        return answer;
    }
}

class Nodes{
    int x;
    int y;
    int cost;
    public Nodes(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }   
}