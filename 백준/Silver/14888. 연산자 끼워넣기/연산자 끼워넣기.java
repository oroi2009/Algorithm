import jdk.jfr.ContentType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] arr;
    static int[] symbols = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            symbols[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(arr[0], 0);
        System.out.println(max);
        System.out.println(min);

    }

    static void backtracking(int n, int depth){
        if(depth == N-1) {
            max = Math.max(max, n);
            min = Math.min(min, n);
            return;
        }

        for(int i = 0; i<4; i++){
            if(symbols[i] <= 0) continue;

            symbols[i]--;

            switch (i) {
                case 0 : backtracking(n + arr[depth+1], depth+1); break;
                case 1 : backtracking(n - arr[depth+1], depth+1); break;
                case 2 : backtracking(n * arr[depth+1], depth+1); break;
                case 3 : backtracking(n / arr[depth+1], depth+1); break;
            }

            symbols[i]++;

        }
    }
}



