import java.io.*;
import java.util.*;

public class Main {
    static int N, num;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (pq.isEmpty()) {
                    sb.append("0\n");
                } else {
                    // 힙에서 가장 작은 값을 제거하고 출력
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.add(num);
            }
        }

        System.out.print(sb.toString());
    }
}