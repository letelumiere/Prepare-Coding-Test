package programmers.basicKit.greedy;
import java.util.*;

public class ReserveBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        for(int i=0, j=people.length-1;j>=i;j--){
            if(i!=j && people[i]+people[j]<=limit) i++;
            ++answer;
        }        

        return answer;
    }
}
