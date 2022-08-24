package backjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LostBracket {

    //부분으로 나누어서 각각의 최적해 도출
    public static int solution(String process){
        int answer = 0;
        String[] str1 = process.split("-");
        int[] sum = new int[str1.length];

        for(int i=0;i<str1.length;i++){
            String[] str2 = str1[i].split("\\+");
            
            for(int j=0;j<str2.length;j++){
                int n = Integer.parseInt(str2[j]);
                sum[i] += n;
            }
        }
        
        answer = sum[0];
        for(int i=1;i<sum.length;i++){
            answer -= sum[i];
        }
        return answer;
    }

    public int solution2(String process){
        int answer = 0;
        String[] str1 = process.split("-");
        int[] sum = new int[str1.length];

        for(int i=0;i<str1.length;++i){
            String[] str2 = str1[i].split("\\+");

            for(int j=0;j<str2.length;++j){
                int n = Integer.parseInt(str2[j]);
                sum[i] += n;
            }
        }

        answer = sum[0];
        for(int i=1;i<sum.length;++i){
            answer -= sum[i];
        }
        return answer;
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String process = br.readLine();
        int result = solution(process);
        System.out.println(result);

        br.close();
        bw.close();
    }
}
