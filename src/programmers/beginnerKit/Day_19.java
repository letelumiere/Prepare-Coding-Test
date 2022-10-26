package programmers.beginnerKit;

public class Day_19 {    
    public int solution19_duplicatedNumberOfArray(int[] array, int n) {
        int answer = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]==n) ++answer;
        }
        return answer;
    }

    public int solution19_longerThanMeoSSuk(int[] array, int height) {
        int answer = 0;
        for(int i : array){
            if(height<i) ++answer;
        }
        return answer;
    }
}
