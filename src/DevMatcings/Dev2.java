package DevMatcings;
import java.util.*;

public class Dev2 {
    static String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
    static String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
    static String[] seller = {"young", "john", "tod", "emily", "mary"};
    static int[] amount = {12, 4, 2, 5, 10};
//    int[] result = {360, 958, 108, 0, 450, 18, 180, 1080};

    public class Member{
        int idx;
        String node;
        String parents;

        Member(int idx, String node, String parents){
            this.idx = idx;
            this.node = node;
            this.parents = parents;
        }
    }
    public int[] solution2(String[] enroll, String[] referral, String[] seller, int[] amount){
        int[] answer = new int[enroll.length];

        HashMap<String, Member> hMap = new HashMap<>();

        for(int i=0;i<enroll.length;i++){
            hMap.put(enroll[i], new Member(i, enroll[i], referral[i]));
        }

        for(int i=0;i<seller.length;i++){
            Member m = hMap.get(seller[i]);
            int profit = amount[i]*100;
            
            while(!m.node.equals("-")){
                if(profit<1) break;

                answer[m.idx] += (profit - (profit/10));
                profit = profit/10;

                if(m.parents.equals("-"))break;
                m = hMap.get(m.parents);
            }
        }



        return answer;
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount){
        int[] answer = new int[enroll.length];
        HashMap<String, String> nodeMap = new HashMap<>(); //son-parents
        HashMap<String, Integer> idxMap = new HashMap<>(); //node-idx;


        for(int i=0;i<enroll.length;i++){
            nodeMap.put(enroll[i], referral[i]);
            idxMap.put(enroll[i], i);
        }

        for(int i=0;i<seller.length;i++){
            String node = seller[i];
            int profit = amount[i] * 100;
            
            while(!node.equals("-")){
                if(profit<1) break;

                int idx = idxMap.get(node);
                answer[idx] += (profit - (profit/10));
                profit = profit/10;

                node = nodeMap.get(node);
            }
        }

        return answer;
    }



    public static void main(String args[]){
        Dev2 s = new Dev2();
        int[] result = s.solution2(enroll, referral, seller, amount);

        for(int i=0;i<result.length;i++){
            System.out.println(enroll[i]+" "+result[i]);
        }

    }




























    public int[] solution_example(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        Map<String, String> parentMap = new HashMap<>(); // <자신, 부모>
        Map<String, Integer> memberIndexMap = new HashMap<>(); // <자신, 자신의 순서>

        for(int i=0; i < enroll.length; i++){
            parentMap.put(enroll[i], referral[i]);
            memberIndexMap.put(enroll[i], i);
        }

        for(int i=0; i<seller.length; i++){

            String now = seller[i];
            int profit = 100 * amount[i];
            
            while(!now.equals("-")){
                int profitForParent = profit / 10; // 부모에게 넘겨줄 금액
                int nowProfit = profit - profitForParent; // 자신이 가져갈 금액

                // 자신의 index에 금액만큼 더함
                answer[memberIndexMap.get(now)] += nowProfit;

                // 노드는 부모로 이동하면서 수익을 부모에게 넘겨준 금액으로 초기화
                now = parentMap.get(now);
                profit /= 10;

                // 10%의 금액이 1원 미만인 경우
                if (profit < 1) {
                    break;
                }
            }
        }

        return answer;
    }
}
