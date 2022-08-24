package algospot;

import java.util.ArrayList;
import java.util.Vector;


public class Chapter4 {

    //chapter 4.1
    //코드 4.1 주어진 배열에서 가장 많이 등장하는 숫자 반환하기 1
    //주어진 배열 A에서 가장 많이 등장하는 숫자를 반환한다.
    //만약 두 가지 이상 있을 경우 아무 것이나 반환한다.

    //N번 수행되는 반복문이 두번 시행되므로, 반복문의 가장 안쪽은 N^2번 수행된다. 
    public int majority1(int[] A){
        int N = A.length;
        int majority = -1, majorityCount = 0;

        for(int i=0;i<N;i++){
            //A에 등장하는 A[i]의 개수를 센다.
            int V = A[i]; 
            int count = 0;
            
            for(int j=0;j<N;++j){
                if(A[j]==V) ++count;
            }
            
            //지금까지 본 최대 빈도보다 많이 출현했다면 답을 갱신한다.
            if(count>majorityCount){
                majorityCount = count;
                majority = V;
            }            
        }
        return majority;
    }

    //코드 4.2 A의 각 원소가 0부터 100사이의 값일 경우 가장 많이 등장하는 숫자를 반환한다.
    //N번의 반복문이 실행되고, 100번의 반복문이 실행되므로 수행 횟수는 N+100이 된다.
    public int majority2(int[] A){
        int N = A.length;
        int[] countArr = new int[101];

        for(int i=0;i<N;++i) {
            countArr[A[i]]++;
        }

        int majority = 0;
        //지금까지 확인한 숫자 중 가장 빈도 수가 큰 숫자를 majority에 저장한다.
        for(int i=1; i<=100; ++i){
            if(countArr[i]>countArr[majority]) majority = i;
        }

        return majority;
    }

    //chapter 4.2  선형시간 알고리즘
    //코드 4.3 - 이동 평균 구하기
    //실수 배열 A가 주어질 때, 각 위치에서 M-이동 평균 값을 구한다.
    //N개의 측정치가 주어질 때, 매달 M달 간의 이동 평균을 구하기.
    public ArrayList<Double> movingAverage1(double[] A, int M){
        ArrayList<Double> ret = new ArrayList();
        int N = A.length;
    
        for(int i=M-1;i<N;++i){     //i를 사용하는 반복문은 N-M+1번 수행
            //A[i]까지의 이동 평균 값을 구하자
            double partialSum = 0;
            for(int j=0;j<M;++j){   //j를 사용하는 반복문은 항상 M번 실행.
                partialSum += A[i-j];
            }
            ret.add(partialSum/M);
        }
        return ret;     //전체 반복문은 M*(N-M+1)=(n*M)-(M^2)+M
                        //N=12, M=3 이면, 반복횟수는 30번
    }

    //코드4.4 선형시간에 이동 평균 구하기
    //N개의 측정치가 주어질 때, 매달 M달 간의 이동 평균을 구하기.
        //코드 4.3에서의 중복 계산을 없애는 아이디어.
            //M이 0일 때를 빼고, M일 째에 측정한 수치를 더한다.
    public ArrayList<Double> movingAverage2(double[] A, int M){
        ArrayList<Double> ret = new ArrayList<>();
        int N = A.length;
        double partialSum = 0;

        //시작시점 이후 M-1일부터 이동평균 계산이 가능하므로, 먼저 계산 
        for(int i=0;i<M-1;++i) {
            partialSum += A[i];
        }
        for(int i=M-1;i<N;++i){
            partialSum += A[i];
            ret.add(partialSum/M);
            partialSum -= A[i-M+1];
        }
        return ret; //반복문의 수행 횟수는 M-1+(N-M+1) = N  
        //C++예제를 JAVA로 바꾼거라 틀릴 수 있음 
    }
    

    //코드 4.5

    //코드 4.6 소인수분해 (맞나??)  - 수행시간과 관련
    public int factor(int n){
        if(n==1) return 1;
        for(int i=2;i<=Math.sqrt(n);i++){
            while(n%i==0){
                System.out.println(i);
                n/=i;
            }
            if(n!=1){
                System.out.println(n);
            }
        }
        return n;
    }


    //코드 4.7 선형탐색
    //array[i]=element인 첫 i를 반환한다. 없으면 -1을 반환한다
    public int firstIndex(int[] array, int element){
        for(int i=0;i<array.length;++i){
            if(array[i]==element) return i;
        }
        return -1;
    }

    //코드 4.8 선택 정렬과 삽입정렬 - 나중에 다른 걸로 교체할것
    //정렬 자체도 중요하지만, 시간복잡도 측정 면에서 더 중요함
    //가장 쉬운 정렬 알고리즘 하나는 숙지해야 함 -> 다른 알고리즘에서 직접 쓰긴 해야 하므로.
        //시간 복잡도 최적화 할 때는 snippet으로 바꿔도 되지만.
    public void selectionSort(int[] A){
        for(int i=0;i<A.length;i++){
            int minIdx = i;
            
            for(int j=i+1;j<A.length;j++){
                if(A[minIdx]>A[j]) {
                    int temp = A[minIdx];
                    A[minIdx] = A[j];
                    A[j] = temp;
                }
            }
        }
    }

    public void insertionSort(int[] A){
        for(int i=0;i<A.length;i++){
            int j=1;
            while(j>0 && A[j-1] > A[j]){
                int temp = A[j-1];
                A[j-1] = A[j];
                A[j] = temp;
                --j;
            }
        }
    }


    //챕터 하나만 붙잡고 있기는 그러므로 나머지 알고리즘 코드 예제는 추후에 넣자.
    
}
