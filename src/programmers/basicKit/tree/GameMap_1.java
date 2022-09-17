package programmers.basicKit.tree;

public class GameMap_1 {
    static int min;
    static boolean visit[][];
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,1,-1,0};

    public int solution(int[][] maps){
        min = Integer.MAX_VALUE;    //어차피 나올 수 없는 기준(Integer.MAX_VALUE를 잡는다)
        visit = new boolean[maps.length][maps[0].length];
        dfs(0,0,maps,0);
        if(min == Integer.MAX_VALUE){   //MAX_VALUE가 변하지 않았다는 것은, 도달하지 않았다는 것을 의미합니다.
            return -1;
        }
        return min;
    }


    public void dfs(int x, int y, int[][] maps,int cnt){
        cnt++;  
        if(x == maps.length-1 && y == maps[0].length-1){
            min = Math.min(cnt, min);
            return;
        }
        for(int i = 0; i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny <0 || nx >= maps.length || ny>= maps[0].length) continue;

            if(!visit[nx][ny] && maps[nx][ny] == 1){
                visit[nx][ny] = true;
                dfs(nx,ny,maps,cnt);
                visit[nx][ny] = false;
            }
        }
    }
}

