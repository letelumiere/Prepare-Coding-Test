package programmers.montlyCode;
import java.util.*; 
public class Question12_3_final {


    //시간 소모된 부분
    //문제 유형 파악
    //자료구조 라이브러리 미숙
    //구현설계 허술하게 하고 진행 
    //index에 약함
    //추상구조에 약함
    //자료구조 흐름에서 어딘가 헷갈렸음 
    // -> 이틀걸림
    public static int[] solution(String[] id_list, String[] report, int k) {        
        HashSet<String> set = new HashSet<>();
        Map<String, Integer> idxMap = new HashMap<>();
        Map<String, ArrayList<String>> penaltyMap = new HashMap<>(); 
        ArrayList<String> alist;
        int[] answer = new int[id_list.length]; 

        for(int i=0;i<id_list.length;++i) idxMap.put(id_list[i], i);
        for(String s : report) set.add(s);

        Iterator<String> iter = set.iterator();
        while(iter.hasNext()){
            String[] temp = iter.next().split(" ");
            String key_0 = temp[0]; String key_1 = temp[1];    
            
            if(penaltyMap.get(key_1)!=null) alist = penaltyMap.get(key_1);
            else alist = new ArrayList<>();

            alist.add(key_0);
            penaltyMap.put(key_1, alist);
        }

        for(String key : penaltyMap.keySet()){
            alist = penaltyMap.get(key);

            if(alist.size()>=k) {
                for(String s : alist) answer[idxMap.get(s)]++;
            }
            
        }
        return answer;        
    }

    public static void main(String args[]){
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo", "apeach muzi"};


        int[] result = solution(id_list, report, 2);

        System.out.print("result : ");
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }
}
