package algospot;

import java.util.ArrayList;
import java.util.Stack;

//3장 알고리즘 설계 패러다임 - 06 무식하게풀기(BruteForce부터)
public class Chapter3_6 {
    //재귀(recursive) -자기 자신을 다시 반복

    //1부터 n까지의 합
    int recursiveSum(int n){
        if(n==1) return 1;
        return n+recursiveSum(n-1);
    }

    //중첩 반복문 대체하기
    //n개의 원소 중에 네개를 고르는 모든 조합의 경우 (0~n까지 정수를 크기 차례대로)
    //중첩 반복문으로 쓸 수 있으나 노가다 그 자체임.
    void repeat(int n){
        for(int i=0;i<n;i++){
            for(int j=i+1;i<n;i++){
                for(int k=j+1;i<n;i++){
                    for(int l=k+1;i<n;i++){
                        System.out.println(i+" "+j+" "+k+" "+l);
                    }
                }
            }
        }
    }

    //재귀 함수를 쓰면
    //n:전체 원소의 수
    //picked : 지금까지 고른 원소들의 번호
    //toPick : 더 고를 원소의 수
    static void pick(int n, ArrayList<Integer> picked, int toPick){ 
        //기저 사례 : 더 고를 원소가 없을 때 고른 원소들을 출력한다.
        if(toPick==0){
            System.out.println(picked); 
            return;
        } //void에서 return은 break; 기능. 안써도 되긴 하나 조건문으로 멈춰야 할 떄는 필요한듯
        
        //고를 수 있는 가장 작은 번호를 계산한다.
        int smallest = picked.isEmpty() ? 0 : picked.get(picked.size()-1) + 1;

        for(int next = smallest; next < n; next++){
            picked.add(next);   //picked에 숫자를 삽입
            pick(n, new ArrayList<Integer>(picked), toPick - 1);    //메서드 pick을 재귀 호출. 중첩 for문을 함수로 돌리는 것과 같음.
            picked.remove(picked.size() - 1);   //
        }
    }
    
//- My Thiking : 그래프 탐색 알고리즘이나 트리의 순회를 재귀함수로 구현했을 때의 유사한 방식이라고 생각했다. 평소에 재귀함수에 대해 약했기 때문에 이러한 알고리즘들을 많이 공부해야 한다고 생각했다. 
//- Logic : 이 코드는 텅 빈 답에서 시작해서 매 단계마다 하나의 원소를 추가하는 일을 반복하다가, 하나의 답을 만든 뒤에는 이전으로 돌아가 다른 원소를 추가하는 식으로 모든 답을 생선한다.여기서 재귀함수를 사용한 이유는 만약 반복문을 사용한다면 m개의 갯수만큼 반복문이 늘어나기 때문에 코드가 길고 복잡해지는데다, 골라야할 원소의 수가 입력에 따라 달라질 수 있는 경우에는 사용할 수 없다는 문제가 있다.
// 내가 쓴 메모는 아님

// stack<E>을 쓸 수 없는 이유는, stack 클래스는 ArrayList와 달리 Collection을 상속 받지 못함.
// 기저사례는 단순 조건문  break가 아니라 재귀호출에서 수행을 완료했을 때의 결괏값을 출력하는 수행문이기도 함

    //코드 6.3 보글 게임판의 해당 위치에서 주어진 단어가 시작하는지를 반환
    //책의 예제에서 입력 매개변수가 정확하지 않음을 감안. 
    int[] dx = {-1, -1, -1, 1, 1, 1, 0, 0};
    int[] dy = {-1, 0, 1, -1, 0, 1, -1, 1};
    //5*5의 보글 게임판의 해당 위치에서 주어진 단어가 시작하는지를 반환.
    public boolean hasWord(int y, int x, String word){
        //기저사례 1 : 시작 위치가 범위 밖이면 무조건 실패
        if(y<0 || y>dy.length-1) return false;
        if(x<0 || x>dx.length-1) return false;

        //기저사례 2 : 첫 글자가 일치하지 않으면 실패
        //if(!board[y][x]==word.charAt(0)) return false;

        //기저 사례 3: 단어 길이가 1이면 성공
        if(word.length()==1) return true;

        //인접한 여덟 칸을 검사한다.
        for(int direction=0;direction<8;++direction){
            int nextY = y + dy[direction], nextX = x+dx[direction];
            if(hasWord(nextY, nextX, word.substring(1))) return true;
        }
        return false;
    }

    //코드 6.4 소풍 문제를 해결하는(잘못된 재귀호출 코드)
    //입력 매개변수 작성까지 고려해야해서 문제 자체를 풀긴 힘듬. 코드 따라 치기함.

    int n;
    boolean[][] areFriends= new boolean[10][10];

    public int countPairings(boolean[] taken){
        //기저사례 : 모든 학생이 짝을 찾았으면 한 가지 방법을 찾았으니 종료.
        boolean finished = true;
        for(int i=0;i<n;++i) {
            if(!taken[i]) finished = false;
        }
        if(finished) return 1;

        int ret = 0;
        //서로 친구인 두 학생을 찾아 짝을 지어준다.
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(!taken[i] && !taken[j] && areFriends[i][j]){
                    taken[i] = taken[j] = true;
                    ret += countPairings(taken);
                    taken[i] = taken[j] = false;
                }
            }
        }
        return ret;
    }

    //코드 6.5 소풍 문제를 해결하는 재귀 호출 코드
    //위와 같음. 
    //taken[i] = i번째 학생이 짝을 이미 찾았으면 true, 아니면 false
    public int countPairings2(boolean[] taken){
        //남은 학생들 중 가장 번호가 빠른 학생을 찾는다.
        int firstFree = -1;
        for(int i=0;i<n;++i){
            if(!taken[i]){
                firstFree = 1;
                break;
            }
        }
        //기저 사례 : 모든 학생이 짝을 찾았으면 한 가지 방법을 찾았으니 종료한다.
        if(firstFree == -1) return 1;
        int ret = 0;
        //이 학생과 짝지을 학생을 결정한다.
        for(int pairWith = firstFree+1;pairWith<n;++pairWith){
            if(!taken[pairWith] && areFriends[firstFree][pairWith]){
                taken[firstFree] = taken[pairWith] = true;
                ret += countPairings2(taken);
                taken[firstFree] = taken[pairWith] = false;
            }
        }
        return ret;
    }

}