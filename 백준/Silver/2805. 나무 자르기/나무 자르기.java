import jdk.jfr.ContentType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int N,M;
    static int tree [];
    static int max = 0,min = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());

            if(max<tree[i]) max = tree[i];
        }

        while(min<max){
            int mid = (min+max)/2;
            long sum = 0;
            for(int treeHeight : tree){
                if(treeHeight - mid > 0) sum += treeHeight - mid;
            }

            if(sum<M) max = mid;

            else min = mid+1;
        }

        System.out.println(min - 1);
    }


}