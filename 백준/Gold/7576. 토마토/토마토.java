import java.io.*;
import java.util.*;

public class Main {
    static int[][] tomatos;
    static int row, column;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        column = Integer.parseInt(st.nextToken()); // M
        row = Integer.parseInt(st.nextToken());    // N

        tomatos = new int[row][column];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < column; j++) {
                tomatos[i][j] = Integer.parseInt(st.nextToken());

                if (tomatos[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < row && ny < column) {
                    if (tomatos[nx][ny] == 0) {
                        queue.add(new int[]{nx, ny});
                        tomatos[nx][ny] = tomatos[x][y] + 1;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (tomatos[i][j] == 0) {
                    return -1;
                }
                count = Math.max(count, tomatos[i][j]);
            }
        }

        return count - 1;
    }
}