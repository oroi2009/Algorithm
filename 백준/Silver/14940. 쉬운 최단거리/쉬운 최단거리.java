import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int[][] check;
    static int[][] visited;
    static int N, M;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] X = {0, 0, 1, -1};
    static int[] Y = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        check = new int[N][M];
        visited = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    queue.add(new int[] {i, j});
                    visited[i][j] = 1;
                }
            }
        }

        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(check[i][j] + " ");
            }
            System.out.println();
        }    }

    private static void bfs(){
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int x, y, nx, ny;
            x = arr[0];
            y = arr[1];
            for(int i = 0; i < 4; i++){
                nx = x+X[i];
                ny = y+Y[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] == 0 && map[nx][ny] != 0){
                    check[nx][ny] = check[x][y] + 1;
                    visited[nx][ny] = 1;
                    queue.add(new int[] {nx, ny});
                }
            }

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1 && check[i][j] == 0){
                    check[i][j] = -1;
                }
            }
        }
    }
}



