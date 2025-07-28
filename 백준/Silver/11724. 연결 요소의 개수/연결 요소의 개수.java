import jdk.jfr.ContentType;

import java.util.Scanner;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int visited [];
    static int node [][];
    static int N;
    static int M;
    static int count = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        M = input.nextInt();

        int a, b;

        visited = new int[N+1];
        node = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            a = input.nextInt();
            b = input.nextInt();

            node[a][b] = 1;
            node[b][a] = 1;
        }


        for (int i = 1; i <= N; i++) {
            if(visited[i] == 0){
                DFS(i);
                count++;
            }
        }
        System.out.println(count);

    }

    public static void DFS(int num){
        if(visited[num] == 1) return;

        visited[num] = 1;
        for(int i = 1; i <= N; i++){
            if(node[num][i] == 1) DFS(i);
        }
    }
}