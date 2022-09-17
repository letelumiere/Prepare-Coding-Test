package programmers.basicKit.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    
    static class Node{
        String next;
        int edge;

        public Node(String next, int edge){
            this.next = next;
            this.edge = edge;
        }
    }

    public int solution(String begin, String target, String[] words){
        int n = words.length;
        int answer = 0;

        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.add(new Node(begin, 0));
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            
            if(cur.next.equals(target)){
                answer = cur.edge;
                break;
            }  

            for(int i=0;i<n;i++){
                if(!visited[i] && isNext(cur.next, words[i])){
                    visited[i] = true;
                    queue.add(new Node(words[i], cur.edge+1));
                }
            }
        }

        return answer;
    }

    static boolean isNext(String cur, String n){
        int cnt = 0;
        for(int i=0;i<n.length();i++){
            if(cur.charAt(i) != n.charAt(i)){
                if(++cnt>1) return false;
            }
        }
        return true;
    }
}
