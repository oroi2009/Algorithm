import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static char[][] campus;
    private static int[][] check;
    private static int[] X = {0, 0, 1, -1};
    private static int[] Y = {1, -1, 0, 0};
    private static int count = 0;
    private static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String temp;

        campus = new char[N][M];
        check = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            temp = st.nextToken();
            for(int j = 0; j<M; j++){
                campus[i][j] = temp.charAt(j);
                if(campus[i][j] == 'I'){
                    queue.add(new int[] {i, j});
                    check[i][j] = 1;
                }
                //System.out.print(campus[i][j] + " ");
            }
            //System.out.println();
        }
        bfs();
        if(count != 0){
            System.out.println(count);
        }else {
            System.out.println("TT");
        }
    }

    private static void bfs(){
        int x, y;
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            x = arr[0];
            y = arr[1];
            //check[x][y] = 1;
            for(int i = 0; i < 4; i++){
                if(x+X[i]>=0 && x+X[i]<N && y+Y[i]>=0 && y+Y[i]<M && check[x+X[i]][y+Y[i]] == 0){
                    check[x+X[i]][y+Y[i]] = 1;
                    if(campus[x+X[i]][y+Y[i]] == 'P'){
                        queue.add(new int[] {x+X[i], y+Y[i]});
                        count++;
                    }
                    else if(campus[x+X[i]][y+Y[i]] == 'O'){
                        queue.add(new int[] {x+X[i], y+Y[i]});
                    }

                }
            }
        }
    }
}