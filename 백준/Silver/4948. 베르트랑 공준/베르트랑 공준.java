import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] primeNumber = new boolean[246913];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        countPrime();

        while(true){
            int count = 0;
            int N = Integer.parseInt(br.readLine());
            if(N == 0){
                break;
            }

            for(int i = N+1; i <= 2*N; i++){
                if(!primeNumber[i])  count++;
            }

            System.out.println(count);
        }
    }

    static void countPrime(){
        primeNumber[0] = primeNumber[1] = true;
        for(int i = 2; i<= Math.sqrt(primeNumber.length); i++){
            if(primeNumber[i]) continue;

            for(int j = i*i; j<primeNumber.length; j += i) {
                primeNumber[j] = true;
            }
        }
    }

}