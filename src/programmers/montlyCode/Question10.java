package programmers.montlyCode;

public class Question10 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10; int right = 12; //상하 = 3, 좌우 = 1 //'#' = 10, '*' = 12?            
        
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==0) numbers[i] = 11;

            if(numbers[i]==1 || numbers[i]==4|| numbers[i]==7) {
                answer += "L";
                left = numbers[i];
            }else if(numbers[i]==3 || numbers[i]==6|| numbers[i]==9) {
                answer += "R";
                right = numbers[i];
            }else if(numbers[i]==2 || numbers[i]==5|| numbers[i]==8 || numbers[i]==0){
                int l = distance(numbers[i], left);
                int r = distance(numbers[i], right); 

                if(l==r){
                    if(hand.equals("left")){
                        answer += "L";
                        left = numbers[i];
                    }else if(hand.equals("right")) {
                        answer += "R";
                        right = numbers[i];
                    }
                }else{
                    if(l<r) {
                        answer += "L";
                        left = numbers[i];                    
                    }else if(l>r){
                        answer += "R";
                        right = numbers[i];                    
                    }
                }
            }
        }

        return answer;
    }


    public int distance(int n, int k){
        int result = 0;
        n = Math.max(Math.abs(n-k), Math.abs(k-n));
        result = n/3;
        result = result + n%3;

        return result;
    }

    
}


/*
[1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]
"right"	"LRLLLRLLRRL"


엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.

 */