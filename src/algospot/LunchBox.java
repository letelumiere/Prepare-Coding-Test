package algospot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class LunchBox {
    public static int[] M;
    public static int[] E;
    public static int N;


    public static int solution(int[] M, int[] E){
        int answer = 0;
        int r = M.length;
        int[][] lunchBoxes = new int[r][r];

        for(int i=0;i<M.length;i++){
            lunchBoxes[i][0] = M[i];
            lunchBoxes[i][1] = i;   //E값을 넣는 대신 M[i]에 해당하는 E의 idx값
        }


        //정렬 자체가 최적해를 도출하는 과정 => 이 문제에서는 가열시간이 오래 걸리는 순서부터 최적화
        Arrays.sort(lunchBoxes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0] ? o1[1]-o2[1] : o1[0]-o2[0];
            }
        });


        //도시락 먹는 시간 = 가열시간 + 먹는시간
        int ret = 0; int beginEat = 0;
        for(int i=r-1;i>=0;--i){
            int box = lunchBoxes[i][1]; //해당 M가 속하는 E의 idx
            beginEat += M[box];
            int eatTime = E[box];

            //식사가 모두 마치는 시간 = (차례대로 도시락 먹는 시간 총합)+해당 도시락의 먹는 시간
            ret = Math.max(ret, beginEat+eatTime);
        }

        //그리디 문제에서의 배열이 나온다고 반드시 배열 순서에 맞출 필요 없음
        //순서가 중요한게 아님. 해당 순서의 최적해가 통용되느냐의 문제임
        //앞날을 보지 않고+그때그때 가장 좋은 선택 = Greedy

        return answer = ret;
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1;
        StringTokenizer st2;


        int T = Integer.parseInt(br.readLine());
        int result[] = new int[T];
        for(int i=0;i<T;++i){
            N = Integer.parseInt(br.readLine());
            M = new int[N]; 
            E = new int[N];

            st1 = new StringTokenizer(br.readLine());
            for(int k=0;k<M.length;++k) M[k] = Integer.parseInt(st1.nextToken());
            
            st2 = new StringTokenizer(br.readLine());
            for(int k=0;k<E.length;++k) E[k] = Integer.parseInt(st2.nextToken());


            result[i] = solution(M, E);
        }

        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }

        br.close();
        bw.close();
    }
}
