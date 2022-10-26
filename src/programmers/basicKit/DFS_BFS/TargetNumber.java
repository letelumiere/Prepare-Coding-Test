package programmers.basicKit.DFS_BFS;

public class TargetNumber {
    int answer = 0;
    
    public int solution(int[] numbers, int target){
        dfs(0, 0, 0, numbers, target);
        return answer;
    }

    public void dfs(int node, int depth, int total, int[] numbers, int target){
        if(depth==numbers.length){
            if(total==target) ++answer;
            return;
        }
        
        dfs(numbers[depth], depth+1, total+numbers[depth], numbers, target);
        dfs(numbers[depth], depth+1, total-numbers[depth], numbers, target);
    }
}
