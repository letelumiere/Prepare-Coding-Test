package backjoon.string;
import java.io.*;
import java.util.HashMap;

public class WordCount {
    public static int solution(String str){
        String[] array = str.split("\\s");
        HashMap<String, Integer> hMap = new HashMap<>();
        int answer = 0;

        
        for(int i=0;i<array.length;i++){
            array[i].replaceAll("\\s+", "");
            if(array[i]!="") hMap.put(array[i], hMap.getOrDefault(array[i], 0)+1);
        }

        for(String key : hMap.keySet()){
            answer += hMap.get(key);
        }
        
        return answer;
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int result = solution(str);

        
        bw.write(result+"\n");
        bw.flush();
        bw.close();
        br.close();
    
    }
}
