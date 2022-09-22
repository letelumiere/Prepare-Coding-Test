package backjoon.graphAndRecursive;
import java.util.*;
import java.io.*;


public class Virus {
    static Stack<Integer>[] adjList;
    static boolean[] visited;
    static int count;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int vertex = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        
        adjList = new Stack[vertex+1];
        visited = new boolean[vertex+1];

        for(int i=0;i<=vertex;i++){
            adjList[i] = new Stack<Integer>();
        }

        for(int i=0;i<edge;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            adjList[n1].push(n2);
            adjList[n2].push(n1);
        }

        visited[1] = true;
        count = 0;
        dfs(1);
        
        
        System.out.println(count);

        br.close();
        bw.close();
    }
    
    public static void dfs(int node){
        while(!adjList[node].isEmpty()){
            int nextNode = adjList[node].pop();

            if(!visited[nextNode]){
                visited[nextNode] = true;
                ++count;

                dfs(nextNode);
            }
        }
    }
}
