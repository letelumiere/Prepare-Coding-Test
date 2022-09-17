package programmers.basicKit.tree;

import java.util.Queue;
import java.util.Stack;


class Node{
    int x, y, turn;    
    public Node(int x, int y, int turn) {
        this.x = x;
        this.y = y;
        this.turn = turn;
    }
}

public class GameMap {
    static int[][] check = {{1,0},{0,1},{-1,0},{0,-1}};
    boolean[][] visited;
    int answer = Integer.MAX_VALUE;

    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        dfs(0, 0, maps, 0);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }   


    public int bfs(int x, int y, int[][] maps, Queue<Node> queue){
        queue.offer(new Node(x, y, 1));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Node n = queue.poll();

            if(n.x==maps.length-1 && n.y==maps[0].length-1) return answer = n.turn;

            for(int i=0;i<check.length;i++){
                int nx = check[i][0] + n.x;
                int ny = check[i][1] + n.y;
                int turn = n.turn;

                if(nx<0 || ny<0 || nx >= maps.length || ny >= maps[0].length) continue;
                if(!visited[nx][ny] && maps[nx][ny]==1){
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, turn+1));
                }
            }
        }

        return answer;
    }
    


    public void dfs(int x, int y, int[][] maps, int turn){
        turn++;
        if(x==maps.length-1 && y==maps[0].length-1) {
            answer = Math.min(turn, answer);
            return;
        }

        for(int i=0;i<check.length;i++){
            int tx = x+check[i][0];
            int ty = y+check[i][1]; 

            if(tx<0 || ty <0 || tx >= maps.length || ty>= maps[0].length) continue;
        
            if(!visited[tx][ty] && maps[tx][ty]==1){
                visited[x][y] = true;
                dfs(tx, ty, maps, turn);
                visited[x][y] = false;    
            }
        }
    }









    //내 경우에는, 해당하는 칸을 재귀한 다음에, 해당 칸의 1,0여부를 체크 하고 다음으로 재귀를 돌렸음.
    //그 경우, 해당하는 칸이 이미 체크가 됐을 때, 더 이상 진행하지 않았음
    //그러므로 길이 막히거나, 길이 한 번 지나쳤으면 멈추는 조건을 걸었으므로
    //또 다른 방향에서 진행이 되지 않는다.
    //그리고 설계는 철저히 해야 한다.
    //GameMap_1.java와 비교하라

    //이 코드의 경우
    //기저 조건에서 역시 어긋
    public void move3(int x, int y, int[][] maps, int turn){
        if((x==maps.length || x<0) || (y==maps.length || y<0)) return;
        else{
            System.out.println(x+":"+y+" = "+maps[x][y]+" turn "+turn);

            if(maps[x][y]==0 || maps[x][y]==2) return;
            if(x==maps.length-1 && y==maps.length-1) {
                answer = turn;
                return;
            }

            maps[x][y] = 2;
            move3(x++, y, maps, turn++);
            move3(x--, y, maps, turn++);
            move3(x, y++, maps, turn++);
            move3(x, y--, maps, turn++);
        }
    }



    //망한 코드. 조건문에서 어긋
    public void move2(int x, int y, int[][] maps, int turn){
        if((x==maps.length || x<0) || (y==maps.length || y<0)) return;
        if(maps[x][y]==0 || maps[x][y]==2) return;

        if(x==maps.length-1 && y==maps.length-1) {
            answer = turn;
            return;
        }

        maps[x][y] = 2;
        move2(x++, y, maps, turn++);
        move2(x--, y, maps, turn++);
        move2(x, y++, maps, turn++);
        move2(x, y--, maps, turn++);
    }

}
