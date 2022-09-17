package backjoon.backTracking;

public class NandM_4 {
    static boolean[] visited;
    static int[] array;
    static int M, N;

    public static void dfs(int at, int depth) {
        if (depth == M) {
            /*
             출력문
            */
        }
            
        for (int i = at; i <= N; i++) {
            array[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }

    public static void DFS(int at, int depth) {
        if (depth == M) {
            /*
             출력문
            */
        }
            
        for (int i = at; i <= N; i++) {
            array[depth] = i;
            dfs(i, depth + 1);
        }
    }
}
